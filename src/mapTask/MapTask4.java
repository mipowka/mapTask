package mapTask;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class MapTask4 {
    public static void main(String[] args) {
        //Создайте Map, содержащую информацию о количестве заказов в интернет-магазине по каждому месяцу.
        Map<Month,Integer> mapOfCountsOrders = new HashMap<>();


        EShop p1 = new EShop(LocalDate.of(2024,5,12),"Iphone14",89_000.99);
        EShop p2 = new EShop(LocalDate.of(2024,5,1),"Huawei",49_500.99);
        EShop p3 = new EShop(LocalDate.of(2024,3,22),"Xiaomi",19_999.99);
        EShop p4 = new EShop(LocalDate.of(2024,7,20),"Iphone15",149_000.99);
        EShop p5 = new EShop(LocalDate.of(2024,12,31),"Oppo",38_100.99);

        List<EShop> listOfProducts = new ArrayList<>();
        listOfProducts.add(p1);
        listOfProducts.add(p2);
        listOfProducts.add(p3);
        listOfProducts.add(p4);
        listOfProducts.add(p5);

        for (EShop product : listOfProducts) {
            mapOfCountsOrders.put(product.month.getMonth(),mapOfCountsOrders.getOrDefault(product.month.getMonth(),0)+1);
        }

        System.out.println(mapOfCountsOrders);
        //---------------------------------------------
        Map<EShop,Double> mapOfProducts = new HashMap<>();
        mapOfProducts.put(p1,p1.price);
        mapOfProducts.put(p2,p2.price);
        mapOfProducts.put(p3,p3.price);
        mapOfProducts.put(p4,p4.price);
        mapOfProducts.put(p5,p5.price);

        System.out.println("Общие покупки в текущем году до 1 мая " + sumOfOrders(mapOfProducts,LocalDate.of(2024,5,1)));


    }
    //Напишите метод, который принимает на вход Map с информацией о заказах и возвращает общую сумму заказов за заданный период времени.
    public static double sumOfOrders(Map<EShop,Double> mapOfProducts,LocalDate localDate){

        Set<Map.Entry<EShop,Double>> entrySet = mapOfProducts.entrySet();

        double sum = 0;

        for (Map.Entry<EShop, Double> product : entrySet) {
            if (localDate.isAfter(product.getKey().month)){
                sum += product.getValue();
            }
        }
        return sum;
    }
}

class EShop{
    LocalDate month;
    String nameOfProduct;
    double price;

    public EShop(LocalDate month, String nameOfProduct, double price) {
        this.month = month;
        this.nameOfProduct = nameOfProduct;
        this.price = price;
    }

    @Override
    public String toString() {
        return "EShop{" +
                "month=" + month +
                ", nameOfProduct='" + nameOfProduct + '\'' +
                ", price=" + price +
                '}' + '\n';
    }
}
