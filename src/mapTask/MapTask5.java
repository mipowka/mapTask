package mapTask;

import java.util.*;

public class MapTask5 {
    public static void main(String[] args) {
        //Создайте Map, содержащую информацию о количестве посещений каждой страницы на сайте.
        Map<String,Integer> countOfVisitingPage = new HashMap<>();

        Site s1 = new Site("Info");
        Site s2 = new Site("FAQ");
        Site s3 = new Site("Menu");
        Site s4 = new Site("FAQ");
        Site s5 = new Site("FAQ");

        List<Site> listOfPages = new ArrayList<>();
        listOfPages.add(s1);
        listOfPages.add(s2);
        listOfPages.add(s3);
        listOfPages.add(s4);
        listOfPages.add(s5);

        for (int i = 0; i < 54; i++) {
            for (Site page : listOfPages) {
                countOfVisitingPage.put(page.nameOfPage,countOfVisitingPage.getOrDefault(page.nameOfPage,0)+1);
            }
        }
        System.out.println(countOfVisitingPage);
        //----------------------------------------

        System.out.println(listOfSites100Plus(countOfVisitingPage) + " страница была посещена более 100 раз");
    }
    //Напишите метод, который принимает на вход Map с информацией о посещениях сайта и возвращает список страниц, которые были посещены более 100 раз.
    public static List<String> listOfSites100Plus(Map<String,Integer> mapLookingMore100){

        Set<Map.Entry<String,Integer>> entrySet = mapLookingMore100.entrySet();

        List<String> listOfSites100Plus = new ArrayList<>();

        for (Map.Entry<String, Integer> site : entrySet) {
            if (site.getValue()>100){
                listOfSites100Plus.add(site.getKey());
            }
        }
        return listOfSites100Plus;
    }
}

class Site{
    String nameOfPage;

    public Site(String nameOfPage) {
        this.nameOfPage = nameOfPage;
    }

    @Override
    public String toString() {
        return "Site{" +
                "nameOfPage='" + nameOfPage + '\'' +
                '}';
    }
}
