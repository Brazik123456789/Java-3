package Lesson_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;
import java.util.Scanner;

public class MainDB {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;
    private static Scanner scanner;

    public static void main(String[] args) {


        try {

            try {
                connect();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            scanner = new Scanner(System.in);
            System.out.println("Введите через пробел название таблицы, далее названия полей с типом данных");
            String [] mass = scanner.nextLine().split(" ");

            create(mass);

            ResultSet rs = stmt.executeQuery("Select * From " + mass[0]);
            ResultSetMetaData rsmd = rs.getMetaData();

            //  меняем значения в этой строке
            insert( "Павел", 15);

           update( "Арту", 25);

            delete(7);
            select(5);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }


    }


    public static void insert (String  name, int score){
        try {
            pstmt = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?)");
            pstmt.setString(1, name);
            pstmt.setInt(2, score);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void update (String  name, int score){
        try {
            pstmt = connection.prepareStatement("UPDATE students set score = ? where name = ?");
            pstmt.setInt(1, score);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void create (String[] str) {
        String sql = "CREATE TABLE IF NOT EXISTS " + str[0] + " (" + str[1] + " " + str[2] + " PRIMARY KEY AUTOINCREMENT";
        for (int i = 0; i <= (str.length - 3) / 2; i++) {
            sql += ", " + str[i + 3] + " " + str[i + 4];
            i++;
        }
        sql += ")";

        System.out.println(sql);

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete (int id){
        try {
            String sql = String.format("DELETE FROM students WHERE ID = " + id );
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void select(int id){
        try {
            String sql = String.format("select * from students WHERE ID < " + id );
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
                System.out.println(rs.getInt(1) + " " + rs.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void connect() throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("JDBC:sqlite:mydb.db");
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
