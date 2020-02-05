package Lesson_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class dz1_fileRead {
    public static void main(String[] args) {
        try (FileInputStream file = new FileInputStream("src/main/java/Lesson_3/Files/file1.txt")){
//            byte[] arr = new byte[70];
            int x;
            while ((x = file.read()) != -1){
                System.out.print(x);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
