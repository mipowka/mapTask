package mapTask;

import java.util.*;

public class MapTask3 {
    public static void main(String[] args) {
        //Создайте Map, содержащую информацию о количестве товаров на складе каждого типа.
        Map<String, Integer> countOfEntities = new HashMap<>();

        Entities en1 = new Entities(1,"Шампунь",150.5);
        Entities en2 = new Entities(2,"Шампунь",50.5);
        Entities en3 = new Entities(3,"Яйца",82.75);
        Entities en4 = new Entities(4,"Котлеты",355.85);
        Entities en5 = new Entities(5,"Кола",70);

        List<Entities> listOfEntities = new ArrayList<>();

        listOfEntities.add(en1);
        listOfEntities.add(en2);
        listOfEntities.add(en3);
        listOfEntities.add(en4);
        listOfEntities.add(en5);

        for (Entities entity : listOfEntities) {
            countOfEntities.put(entity.name,countOfEntities.getOrDefault(entity.name,0)+1);
        }

        System.out.println(countOfEntities);
        //______________________________________
        Map<Entities,Double> mapOfProducts = new HashMap<>();
        mapOfProducts.put(en1,en1.price);
        mapOfProducts.put(en2,en2.price);
        mapOfProducts.put(en3,en3.price);
        mapOfProducts.put(en4,en4.price);
        mapOfProducts.put(en5,en5.price);

        System.out.println(toPrice(mapOfProducts, 100.99));

    }
    //Напишите метод, который принимает на вход Map с ценами товаров и возвращает список товаров, стоимость которых не превышает заданную.
    public static List<Entities> toPrice(Map<Entities,Double> mapOfProducts,double priceOfProduct){

        Set<Map.Entry<Entities,Double>> entrySet = mapOfProducts.entrySet();

        List<Entities> listOfProducts = new ArrayList<>();

        for (Map.Entry<Entities, Double> entity : entrySet) {
            if (entity.getValue() <= priceOfProduct){
                listOfProducts.add(entity.getKey());
            }
        }
        return listOfProducts;
    }
}

class Entities{
    String name;
    int id;
    double price;

    public Entities(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Entities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}' + '\n';
    }
}
