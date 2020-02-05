package Lesson_3.dz4_ClientServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket server;
    private static Socket socket;

    private static ObjectOutputStream outObj;
    private static ObjectInputStream inObj;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(5553);
            System.out.println("Server on");

            socket = server.accept();
            System.out.println("Client connect");

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){
                            try {
                                inObj = new ObjectInputStream(socket.getInputStream());
                                Human human = (Human) inObj.readObject();
                                inObj.close();
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
                            outObj = new ObjectOutputStream(socket.getOutputStream());
                            Human human = new Human("Andrew", 50, "RZHD");
                            outObj.writeObject(human);
                            outObj.close();

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
        }finally {
            try {
                socket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
