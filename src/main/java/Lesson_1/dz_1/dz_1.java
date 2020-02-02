package Lesson_1.dz_1;

import java.util.ArrayList;
import java.util.Random;

public class dz_1 <T> {
    private T []  Arr;

    public dz_1(T[] arr) {
        Arr = arr;
    }


    public void arrayNew(int a, int b){
        for (T o: Arr) {
            System.out.print(o + " ");
        }
        System.out.println();

        T x = Arr[a];
        Arr[a] = Arr[b];
        Arr[b] = x;

        for (T o: Arr) {
            System.out.print(o + " ");
        }
    }

};

