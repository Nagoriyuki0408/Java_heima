package example_method;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ConstructorDemo {
    public static void main(String[] args) {
        // 目标：理解构造器引用

        // 创建了接口的匿名内部类对象 (注释掉，因为后面使用了 Lambda 表达式和构造器引用)
        // CarFactory cf =new CarFactory(){
        //     @Override
        //     public Car getCar(String name) {
        //         return null;
        //     }
        // }

        // 使用 Lambda 表达式创建 CarFactory 接口的实现 (注释掉，因为后面使用了构造器引用)
        // CarFactory cf = name->new Car(name);

        // 使用构造器引用：Car::new  等价于  name -> new Car(name)
        // Car::new  表示引用 Car 类的构造方法，该构造方法接受一个 String 类型的参数
        CarFactory cf = Car::new;

        // 调用 CarFactory 接口的 getCar 方法，传入 "保时捷" 作为参数，创建一个 Car 对象
        Car car = cf.getCar("保时捷");

        // 打印 Car 对象的信息，会调用 Car 类的 toString 方法 (由 Lombok 的 @Data 注解自动生成)
        System.out.println(car);
    }

    // 定义一个函数式接口 CarFactory，该接口只有一个抽象方法 getCar
    interface CarFactory {
        Car getCar(String name);
    }

    // 使用 Lombok 注解简化 Car 类的编写
    @Data // 自动生成 getter、setter、toString、equals 和 hashCode 方法
    @AllArgsConstructor // 自动生成包含所有参数的构造方法
    @NoArgsConstructor // 自动生成无参构造方法
    static class Car {
        private String name; // 汽车的名字
    }
}