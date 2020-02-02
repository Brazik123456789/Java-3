package Lesson_1.dz_3;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    ArrayList <T> box;

    public Box(ArrayList<T> box) {
        this.box = box;
    }

    //  метод высчитывания веса коробки // в моей реализации каждый фрукт может иметь свой индивидуальный вес, не равный весу другого такого же фрукта. Всё зависит от того, какой мы сами вес в него заложим
    public float getWeight(){
        float weight = 0;
        for (T o: this.box) {
            weight += o.weight;
        }
       return weight;
    };

    //метод сравнения текущей коробки с коробкой, поданной в качестве параметра
    public boolean compare (Box box_){
        return (this.getWeight() == box_.getWeight());
    }

    //  метод пересыпки фруктов из текущей коробки в другую коробку
    public void FruitFromThisBoxToAnotherBox(Box<T> anotherBox) {
        for (T o : this.box) {
            anotherBox.box.add(o);
        }
        this.box.clear();

        //  Изначально прописал такую реализацию, но выдавало ошибку. По логике вроде как все должно работать: мы добавдяем фрукт в новую коробку и сразу же его удаляем из старой
//        for (T o : this.box) {
//            anotherBox.box.add(o);
//            box.remove(o);
//        }
    }

    //  метод добавления фрукта в коробку
    public void fruitAdd (T fruit) {
        this.box.add(fruit);
    }
}