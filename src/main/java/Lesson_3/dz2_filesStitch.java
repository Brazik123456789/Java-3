package Lesson_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class dz2_filesStitch {
    public static void main(String[] args) {
        try {
            ArrayList<InputStream> collOfFiles = new ArrayList<>();
            for (int i = 2; i <= 6; i++) {
                collOfFiles.add(new FileInputStream("src/main/java/Lesson_3/Files/file" + i +".txt"));
            }

            SequenceInputStream resultFile = new SequenceInputStream(Collections.enumeration(collOfFiles));

            int x;
            while ((x = resultFile.read()) != -1)
                System.out.print((char)x);

            resultFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}