package ArrayList;
import java.util.ArrayList;

public class ArrayListDemo1 {

        public static void main(String[] args) {
            // 创建一个 ArrayList 对象，存储字符串
            ArrayList<String> list = new ArrayList<>();

            // 添加元素
            list.add("Apple");
            list.add("Banana");
            list.add("Orange");

            // 打印列表
            System.out.println("List: " + list); // 输出: List: [Apple, Banana, Orange]

            // 获取元素
            String element = list.get(1);
            System.out.println("Element at index 1: " + element); // 输出: Element at index 1: Banana

            // 修改元素
            list.set(0, "Grape");
            System.out.println("List after modification: " + list); // 输出: List after modification: [Grape, Banana, Orange]

            // 删除元素
            list.remove(2);
            System.out.println("List after removal: " + list); // 输出: List after removal: [Grape, Banana]

            // 列表大小
            System.out.println("Size of the list: " + list.size()); // 输出: Size of the list: 2

            // 检查是否包含元素
            boolean contains = list.contains("Banana");
            System.out.println("List contains Banana: " + contains); // 输出: List contains Banana: true
        }
}
