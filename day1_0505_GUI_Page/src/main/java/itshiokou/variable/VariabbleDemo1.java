package itshiokou.variable;

public class VariabbleDemo1 {
    public static void main(String[] args){
        //目标：变量的使用
        printVariable();
    }
    //定义一个方法，来学习变量的定义
    public static void printVariable(){
        //定义变量:数据类型、变量名称
        int age =18;
        System.out.println(age);

        //定义一个小数变量，存储一个学生的Java成绩
        double score = 99.5;
        System.out.println(score);
        System.out.println("==========================================");
        System.out.println("18");
        System.out.println("18");
        System.out.println("18");
        System.out.println("18");
        System.out.println("==========================================");
        //研究变量的特点
        int age2=18;
        age2=19;//赋值语句
        System.out.println(age2);
        System.out.println("==========================================");

    }
    //提高数据的灵活性和维护性
}
