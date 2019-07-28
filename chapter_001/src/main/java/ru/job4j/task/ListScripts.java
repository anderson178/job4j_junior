package ru.job4j.task;

import java.util.*;

public class ListScripts {
    private List<Integer> listScripts = new ArrayList<>();
    private final Map<Integer, List<Integer>> map;
    private int numberScripts;

    public ListScripts(Map<Integer, List<Integer>> map, int numberScripts) {
        this.map = map;
        this.numberScripts = numberScripts;
    }

    public List<Integer> load() {
        return recursion(new ArrayList<>(Collections.singletonList(numberScripts)));
    }

    private List<Integer> recursion(List<Integer> list) {
        if (!list.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            list.forEach(number ->
            {
                map.get(number).forEach(numberKey ->
                {
                    temp.add(numberKey);
                    listScripts.add(numberKey);
                });
            });
            recursion(temp);
        }
        return listScripts;
    }



    @Override
    public int hashCode() {
        return Objects.hash(listScripts, map, numberScripts);
    }
}
