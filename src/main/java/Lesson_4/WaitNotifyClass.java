package Lesson_4;

public class WaitNotifyClass {
    private final Object obj = new Object();
    private volatile char letter = 'A';

    public static void main(String[] args) {
        WaitNotifyClass wnf = new WaitNotifyClass();
        Thread t1 = new Thread(()->{
            wnf.printA();
        });
        Thread t2 = new Thread(()->{
            wnf.printB();
        });
        Thread t3 = new Thread(()->{
            wnf.printC();
        });

        t1.start();
        t2.start();
        t3.start();
    }

    private void printA(){
        synchronized (obj){
            for (int i = 0; i < 5; i++) {
                while (letter != 'A'){
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(letter);
                letter = 'B';
                obj.notifyAll();
            }
        }
    }

    private void printB(){
        synchronized (obj){
            for (int i = 0; i < 5; i++) {
                while (letter != 'B'){
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(letter);
                letter = 'C';
                obj.notifyAll();
            }
        }
    }

    private void printC(){
        synchronized (obj){
            for (int i = 0; i < 5; i++) {
                while (letter != 'C'){
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(letter);
                letter = 'A';
                obj.notifyAll();
            }
        }
    }
}
