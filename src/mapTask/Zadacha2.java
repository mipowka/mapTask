package mapTask;

import java.util.*;

public class Zadacha2 {
    public static void main(String[] args) {
        //Написать метод который вернет число которое часто встречается в массиве
        int[] numbers = {1,1,1,2,3,4,5,6,6,6,6,6};
        System.out.println(oftenNumber(numbers) + " встречается чаще других");

    }

    public static int oftenNumber(int[] numbers){
        Map<Integer,Integer> mapWithNumbers = new HashMap<>();
        int max = 0;

        List<Integer> listOfNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            listOfNumbers.add(numbers[i]);
        }

        for (Integer number : listOfNumbers) {
            mapWithNumbers.put(number,mapWithNumbers.getOrDefault(number,0)+1);
        }



        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(mapWithNumbers.entrySet());

        for (Map.Entry<Integer, Integer> number : entryList) {
            if (number.getValue() > max){
                max = number.getKey();
            }
        }

        return max;
    }
}
