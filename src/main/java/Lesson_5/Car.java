package Lesson_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static boolean Win = false;
//    CountDownLatch countDownLatch;

    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private static CyclicBarrier cb;
    private CountDownLatch cd;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier cb, CountDownLatch cd) {
        this.race = race;
        this.speed = speed;
        this.cb = cb;
        this.cd = cd;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();
            cb.await();

        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        CheckWinner(this);

//        cd.countDown();
//        try {
//            cd.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        try {
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


    }

    private void CheckWinner(Car car){
        if (!Win){
            this.Win = true;
            System.out.println(car.getName() + " WIN!");
        }
    }
}
