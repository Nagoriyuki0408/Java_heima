package itshiokou.wrtter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class writer {
    public static void main(String[] args) {
        // 声明一个 BufferedWriter 对象，用于写入文件
        BufferedWriter writer = null;
        try {
            // 创建 BufferedWriter 对象，并关联到文件 "output.txt"
            // FileWriter 用于将字符写入文件
            // BufferedWriter 提供了缓冲功能，可以提高写入效率
            writer = new BufferedWriter(new FileWriter("F:\\js1_ai\\day01_helloworld-app\\src\\com\\itshiokou\\wrtter\\output.txt"));

            // 将字符串 "Hello, World!" 写入文件
            writer.write("Hello, World!");

            // 写入一个换行符，确保下一行内容另起一行
            writer.newLine();

            // 将字符串 "This is a new line." 写入文件
            writer.write("This is a new line.");

        } catch (IOException e) {
            // 捕获可能发生的 IOException 异常，例如文件不存在、权限不足等
            // 打印异常堆栈信息，方便调试
            e.printStackTrace();
        } finally {
            // finally 块中的代码无论是否发生异常都会执行
            // 用于确保资源被正确释放，例如关闭文件流

            try {
                // 检查 writer 对象是否为空，避免空指针异常
                if (writer != null) {
                    // 关闭 BufferedWriter 对象，释放资源
                    // 关闭流之前，缓冲区中的数据会被刷新到文件中
                    writer.close();
                }
            } catch (IOException e) {
                // 捕获关闭流时可能发生的 IOException 异常
                // 打印异常堆栈信息，方便调试
                e.printStackTrace();
            }
        }
    }
}
