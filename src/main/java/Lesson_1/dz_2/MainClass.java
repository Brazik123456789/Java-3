package Lesson_1.dz_2;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        //  1-й метод с использованием стороннего класса, однако необходимо создавать объект стороннего класса с нужным нам типом данных, в зависимости от того, какой тип данных используется в создаваемом массиве
        String[] array = {"G", "E", "E", "K", "B", "R", "A", "I", "N", "S"};
        ArrayList <String> arrayList = new ArrayList<String>();
        ArrToArrayList<String> newArrayList = new ArrToArrayList<String>(arrayList);
        newArrayList.ArrToArrayList(array);
        for (String o : newArrayList.arrayList) {
            System.out.print(o + " ");
        }

//        //  2-й метод хотел реализовать без использования стороннего класса, якобы создать объект ArrayList'а с неизвестным типом данных, а потом в него засовывать объекты.
//            Думал что он без проблем будет добавлять объекты и сразу примет тот тип данных, который указан у объектов.
//            Однако Java ругается.
//            Надеюсь, Вы поняли мою задумку
//            Прошу на вебинаре рассказать студентом про этот случай и разъяснить, почему так происходит. А при возможности реализации моей задумки показать, как это можно сделать

//        String[] array1 = {"G", "E", "E", "K", "B", "R", "A", "I", "N", "S"};
//        ArrayList < Class<? extends Object>> arrayList1 = new ArrayList<Class<? extends Object>>();
//        for (String o : array1) {
//            arrayList1.add(o);
//        }



    }


}
