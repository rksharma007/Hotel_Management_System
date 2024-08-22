package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverClass {
    private static final String user= "avnadmin";
    private static final String password = "AVNS_f8nTcBG95-F_WEUcRih";
    private static final String dbURL = "jdbc:mysql://mysql-rk-69-hotel-69.h.aivencloud.com:21410/defaultdb";
    static Connection connection;
    static Connection connectDB() {
        try {//org.apache.derby.jdbc.EmbeddedDriver"
            System.out.println("Loading driver!!!");
            //Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            System.out.println("mysql Driver Class found and loaded!!!");
            if(connection==null) {
                connection = DriverManager.getConnection(dbURL, user, password);      //gets a Connection object
                System.out.println("Connected to DB!!");
            }
            else {
                System.out.println("Error: Not connected to DB!!");

            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
