package Lesson_3.dz4_ClientServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    private static Socket socket;

    private static String IP_Adress = "localhost";
    private static int PORT = 5553;

    private static ObjectOutputStream outObj;
    private static ObjectInputStream inObj;

    public static void main(String[] args) {
        try {
            socket = new Socket(IP_Adress,PORT);
            inObj = new ObjectInputStream(socket.getInputStream());
            outObj = new ObjectOutputStream(socket.getOutputStream());

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){
                            try {

                                Human human = (Human) inObj.readObject();
                                human.info();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }

                        }
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            });
            t1.start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){
                            Human human = new Human("Egor", 19, "Student");
                            outObj.writeObject(human);

                            try {
                                Thread.sleep(15000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    } catch (IOException e){
                        e.printStackTrace();
                    }

                }
            }).start();



            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}