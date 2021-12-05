
package DAO;

import java.sql.*;
import com.mysql.cj.jdbc.ConnectionImpl;


public class DBConnection {
    public static Connection getConnection() {
        Connection cons = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cons = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sieuThi", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
