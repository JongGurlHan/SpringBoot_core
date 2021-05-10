package hello.core.singleton;

public class StatefulService {

//    private int price;

    //스프링 빈은 항상 무상태(stateless)로 설계하자

//    public void order(String name, int price){
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price;
//    }
     public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        //this.price = price;
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
