package example_method;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Demo3 {
    public static void main(String[] args) {
        //目标：理解构造器引用
        //创建了接口的匿名内部类对象
//        CarFactory cf =new CarFactory(){
//            @Override
//            public Car getCar(String name) {
//                return null;
//            }
//        }
//    CarFactory cf = name->new Car(name);
    //可以替换为引用
    CarFactory cf = Car::new;
    Car car = cf.getCar("保时捷");
    System.out.println(car);
    }
    interface CarFactory{
        Car getCar(String name);
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Car{
        private String name;
    }
}
