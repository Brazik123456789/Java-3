package Lesson_7;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainClassForTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ClassTest classTest = new ClassTest();
        start(classTest);
    }


    public static void start (ClassTest c) throws InvocationTargetException, IllegalAccessException {

        Method[] methods = c.getClass().getDeclaredMethods();
        ArrayList<Method> massMethod = new ArrayList<>();

        //  бежим по методам и добавляем все, у которых есть аннотация @Test
        for (Method o: methods) {
            if (o.isAnnotationPresent(Test.class)){
                massMethod.add(o);
            }
        }

        //  сортируем
        Collections.sort(massMethod, new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o1.getAnnotation(Test.class).prioritet() - o2.getAnnotation(Test.class).prioritet();
            }
        });

        //  бежим по методам и добавляем BeforeSuite и AfterSuite
        for (Method o: methods) {
            if (o.isAnnotationPresent(BeforeSuite.class)){
                if (!massMethod.get(0).isAnnotationPresent(BeforeSuite.class)){
                    massMethod.add(0, o);
                } else throw new RuntimeException("Методов с аннотацией BeforeSuite больше 1");

            } else if (o.isAnnotationPresent(AfterSuite.class)){
                if (!massMethod.get(massMethod.size()-1).isAnnotationPresent(AfterSuite.class)){
                    massMethod.add(o);
                } else throw new RuntimeException("Методов с аннотацией AfterSuite больше 1");
            }
        }

        for (Method o: massMethod) {
            o.invoke(c);
        }

    }


}
