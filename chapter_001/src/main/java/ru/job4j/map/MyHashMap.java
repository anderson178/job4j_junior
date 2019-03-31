package ru.job4j.map;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.3.2019
 */

public class MyHashMap<K, V> implements Iterable<MyHashMap.Node> {
    private int modCount;
    private int size;
    private Node[] map;
    private int fillCount;
    private double loadFactory;

    public MyHashMap() {
        this.size = 2;
        map = new Node[this.size];

    }

    public MyHashMap(int size) {
        this.size = size;
        map = new Node[size];
        this.loadFactory = 0.75;
    }

    public MyHashMap(int size, double loadFactory) {
        this.loadFactory = loadFactory;
        this.size = size;
        map = new Node[size];
    }

    /**
     * Method to return iterator for myHashMap
     *
     * @return - iterator
     */
    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {
            int cursor;
            int innerModCount = modCount;
            int innerFillCount;

            @Override
            public boolean hasNext() {
                int countCycle = cursor;
                boolean rst = false;
                if (this.innerModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = countCycle; (i < map.length) && (this.innerFillCount <= fillCount); i++) {
                    if (map[i] != null) {
                        cursor = i;

                        rst = true;
                        break;
                    }
                }
                return rst;
            }

            @Override
            public Node next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.innerFillCount++;
                return map[cursor++];
            }
        };
    }

    /**
     * Method to add Node in the map
     *
     * @param index - index to insert for array Node
     * @param node  - object node
     */
    private void addElement(int index, Node<K, V> node) {
        if (this.fillCount >= this.map.length * this.loadFactory) {
            this.reSize();
        }
        map[index] = node;
        this.modCount++;
        this.fillCount++;
    }

    /**
     * Method replace value for Key
     *
     * @param index - index to insert for array Node
     * @param value - is value for the Node
     */
    private void replaceValue(int index, V value) {
        this.map[index].setValue((Object) value);
        this.modCount++;
    }


    /**
     * Method to change of the map
     */
    private void reSize() {
        this.size = this.size * this.size;
        Node[] tempMap = new Node[this.size];
        for (int i = 0; i < this.map.length; i++) {
            if (this.map[i] != null) {
                tempMap[this.indexTable((K) this.map[i].key)] = this.map[i];
            }
        }
        this.modCount++;
        this.map = tempMap;
    }

    /**
     * Method insert the object Node in the map
     *
     * @param key-  is key for the Node
     * @param value - is value for the Node
     * @return
     */
    public boolean insert(K key, V value) {
        boolean rst = false;
        int index = this.indexTable(key);
        if (this.map[index] == null) {
            this.addElement(index, new Node<K, V>(key, value));
            rst = true;
        } else if ((this.map[index].getKey().hashCode() == key.hashCode()) && (this.map[index].getKey().equals(key))) {
            this.replaceValue(index, value);
            rst = true;
        }
        return rst;
    }

    /**
     * Method the hash function
     *
     * @param key - is key for the Node
     * @return - index to insert for array Node
     */
    private int indexTable(K key) {
        return (this.size - 1) & this.hashKey(key);
    }

    /**
     * Method to calculator hashcode for the Key
     *
     * @param key - is key for the Node
     * @return - hashcode
     */
    private int hashKey(K key) {
        return (key == null) ? 0 : key.hashCode() ^ (key.hashCode() >>> 16);
    }

    /**
     * Method to return value of the Node
     *
     * @param key- is key for the Node
     * @return - value of the Node
     */
    public V get(K key) {
        return map[this.indexTable(key)] == null ? null : (V) map[this.indexTable(key)].value;
    }

    /**
     * Ьethod returns the number of objects in the map
     *
     * @return - the number of objects in the map
     */
    public int getFillCount() {
        return fillCount;
    }

    /**
     * Method removes object by key
     * @param key- is key for the Node
     * @return - the true if this object deleted else false
     */
    public boolean remove(K key) {
        boolean rst = false;
        int index = this.indexTable(key);
        if ((map[index].key.hashCode() == key.hashCode()) && (map[index].key.equals(key))) {
            map[index] = null;
            this.modCount++;
            this.fillCount--;
            rst = true;
        }
        return rst;
    }

    protected static class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }
    }
}
