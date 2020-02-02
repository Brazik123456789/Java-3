package Lesson_1.dz_1;

public class MainClass {


    public static void main(String[] args) {

        int n = 15;     // указываем кол-во элементов массива
        Double [] arr = new Double[n];

        // При заполнении массива foreach -ем его элементы были равны null. Пришлось использовать обычный fori Скажите в комментарии, пожалуйста, почему так?
//        for (Double o: arr) {
//            o = Math.floor(Math.random() * 100);
//        }

        for (int i = 0; i < n; i++) {
            arr[i] = Math.floor(Math.random() * 100);
        }

        int a = (int) (Math.random() * (n-1));
        int b = (int) (Math.random() * (n-1));

        dz_1 <Double> arr1 = new dz_1<Double>(arr);
        arr1.arrayNew(a,b);
    }
}
