package Lesson_6;


import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;


public class lolg4j {
    public static void main(String[] args) {


        Logger admin = Logger.getLogger("admin");

        admin.info("This is info");
        admin.warn("This is warn");
        admin.error("This is error");
        admin.fatal("This is fatal");

        Logger file = Logger.getLogger("file");

        file.info("This is info");
        file.warn("This is warn");
        file.error("This is error");
        file.fatal("This is fatal");

        Logger user = Logger.getLogger("user");
        user.info("This is info");
        user.warn("This is warn");
        user.error("This is error");
        user.fatal("This is fatal");
    }
}
