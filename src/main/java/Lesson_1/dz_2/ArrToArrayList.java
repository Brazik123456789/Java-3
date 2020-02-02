package Lesson_1.dz_2;

import java.util.ArrayList;

public class ArrToArrayList <T> {
    ArrayList<T> arrayList;

    public ArrToArrayList(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }

    public void ArrToArrayList (T[] arr){
        for (T o : arr) {
            this.arrayList.add(o);
        }
    }

}
