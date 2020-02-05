package Lesson_3.dz4_ClientServer;

import java.io.Serializable;

public class Human implements Serializable {
    String name;
    int age;
    String job;

    public Human(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public void info(){
        System.out.println(name + ", " + age + " лет, " + job);
    }

}
