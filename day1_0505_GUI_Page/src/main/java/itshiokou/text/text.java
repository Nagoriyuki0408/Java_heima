package itshiokou.text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class text {
    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            // 指定文件编码为 UTF-8
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("F:\\js1_ai\\day01_helloworld-app\\src\\com\\itshiokou\\text\\1.txt"), "UTF-8"));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
