package mapTask;

import java.util.*;

public class MapTask1 {
    public static void main(String[] args) {
        // Создайте Map, содержащую информацию о количестве каждого уникального слова в заданном тексте.
        Map<String, Integer> uniqueWord = new HashMap<>();

        String s = "Это будет текст с повторяющимися словами чтобы проверить количество каждого уникального " +
                "слова в заданном тексте или не тексте ну короче ну это текст";
        String lowText = s.toLowerCase();
        List<String> listOfWords = new ArrayList<>();
        listOfWords.addAll(List.of(lowText.split(" ")));
        for (String word : listOfWords) {
            uniqueWord.put(word, uniqueWord.getOrDefault(word,0)+1);
        }

        System.out.println(uniqueWord);
        //----------------------------------------------------
        Map<String, Integer> forMethod = new HashMap<>();
        topWords(forMethod);
    }

    /*Напишите метод, который принимает на вход Map, содержащую информацию о количестве уникальных слов в тексте,
    и выводит топ-10 самых часто встречающихся слов.
     */

    public static void topWords(Map<String, Integer> mapOfWords){
        System.out.println("Введите ваш текст");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String textLow = text.toLowerCase();

        List<String> listOfWords = new ArrayList<>();
        listOfWords.addAll(List.of(textLow.split(" ")));

        for (String word : listOfWords) {
            mapOfWords.put(word,mapOfWords.getOrDefault(word,0)+1);
        }

        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(mapOfWords.entrySet());
        Collections.sort(entryList,(e1,e2)->Integer.compare(e2.getValue(),e1.getValue()));
        System.out.println(entryList.stream().limit(10).toList());
    }
}




