package mapTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zadacha3 {
    public static void main(String[] args) {
        /*
        Поменять ключи и значения в Map пакет тот же
        Напишите метод, который получает на вход Map<K, V> и возвращает Map, где ключи и значения поменяны местами.
        Так как значения могут совпадать, то тип значения в Map будет уже не K,  а V
         */
        Map<String,Integer> mapToReverse = new HashMap<>();

        mapToReverse.put("Denga",1000);
        mapToReverse.put("Cow",100);
        mapToReverse.put("1",101);
        mapToReverse.put("2",100);

        System.out.println(mapToReverse);
        System.out.println(reverseMap(mapToReverse));

    }

    public static Map<Integer,String> reverseMap(Map<String,Integer> mapToReverse){
        Map<Integer,String> reversedMap = new HashMap<>();

        List<Map.Entry<String,Integer>> listToReverse = new ArrayList<>(mapToReverse.entrySet());

        for (Map.Entry<String, Integer> s : listToReverse) {
            reversedMap.put(s.getValue(),s.getKey());
        }

        return reversedMap;
    }
}
