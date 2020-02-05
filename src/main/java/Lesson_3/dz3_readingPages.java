package Lesson_3;

import java.io.*;

public class dz3_readingPages {
    private static FileReader fr;
    private static BufferedReader br;

    public static void main(String[] args) {

        File file = new File("src/main/java/Lesson_3/Files/text1800.txt");  //  в этом файле произведение Д.Н. Толстого "Война и мир" продублирована 4 раза, для достижения размера > 10 мб
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr, 3240);  //  столько байт приходится на 1800 символов

            String line;
            long t = System.currentTimeMillis();
            while ((line = br.readLine()) != null)
                System.out.println(line);
            System.out.println(System.currentTimeMillis()-t);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
