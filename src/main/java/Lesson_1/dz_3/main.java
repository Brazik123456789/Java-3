package Lesson_1.dz_3;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.awt.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        //  купили 3 апельсина
        Orange orange1 = new Orange(1);
        Orange orange2 = new Orange(2);
        Orange orange3 = new Orange((float) 1.5);

        //  купили пакет для апельсинов и положили их туда
        ArrayList <Orange> orangesArrToBox = new ArrayList();
        orangesArrToBox.add(orange1);
        orangesArrToBox.add(orange2);
        orangesArrToBox.add(orange3);

        //  купили 4 яблока
        Apple apple1 = new Apple((float) 0.5);
        Apple apple2 = new Apple((float) 0.7);
        Apple apple3 = new Apple((float) 1.5);
        Apple apple4 = new Apple((float) 2.5);

        //  купили пакет для яблок и положили их туда
        ArrayList <Apple> applesArrToBox = new ArrayList();
        applesArrToBox.add(apple1);
        applesArrToBox.add(apple2);
        applesArrToBox.add(apple3);
        applesArrToBox.add(apple4);

        // кладем пакеты с яблоками и апельсинами в свои коробки
        Box <Apple> appleBox = new Box<Apple>(applesArrToBox);
        Box <Orange> orangeBox = new Box<Orange>(orangesArrToBox);

        System.out.println("Вес коробки с яблоками равен " + appleBox.getWeight());
        System.out.println("Вес коробки с апельсинами равен " + orangeBox.getWeight());

        //  сверим коробки по весу
        if (appleBox.compare(orangeBox)){
            System.out.println("Коробки равны по весу");
        } else {
            System.out.println("Коробки не равны по весу");
        }

        //  создадим пустую коробку для яблок (для этого купим пустой пакет и положим его туда)
        ArrayList<Apple> applesArrToBox1 = new ArrayList<Apple>();
        Box <Apple> appleBox1 = new Box<Apple>(applesArrToBox1);
        appleBox.FruitFromThisBoxToAnotherBox(appleBox1);       //  перекладываем яблоки из старой коробки в новую
        //  ну и проверим их вес
        System.out.println("Вес старой коробки с яблоками равен " + appleBox.getWeight());
        System.out.println("Вес новой коробки с яблоками равен " + appleBox1.getWeight());

        // купим яблоко и добавим его в старую коробку, а потом проверим вес этой коробки
        Apple apple5 = new Apple((float) 0.3);
        appleBox.fruitAdd(apple5);
        System.out.println(appleBox.getWeight());









    }


}
