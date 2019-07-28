package ru.job4j.task;

import org.junit.Test;

import java.util.*;

public class ListScriptsTest {

    @Test
    public void whenTenHotels() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, new ArrayList<>(Arrays.asList(2,3)));
        map.put(2, new ArrayList<>(Collections.singletonList(4)));
        map.put(3, new ArrayList<>(Arrays.asList(4,5)));
        map.put(4, new ArrayList<>());
        map.put(5, new ArrayList<>());
        ListScripts listScripts = new ListScripts(map,1);

        System.out.println(listScripts.load());
        //System.out.println(listScripts.getListScripts());


    }
}
