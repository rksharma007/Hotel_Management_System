import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.DBConnection;
import models.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        System.out.println(login("adminahuja", "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918"));
//        Connection connection = DBConnection.get_connection();
//
//        String sql= "SELECT * FROM Admin WHERE admin_username='adminahuja' and admin_password='8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918'";
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs =statement.executeQuery(sql);
//            ResultSetMetaData resultSetMetaData =rs.getMetaData();
//            int colCount = resultSetMetaData.getColumnCount();
////            System.out.println(colCount)
//            if(colCount == 0)
//                System.out.println("Admin doesnt exist");
//            else
//                System.out.println("Admin exist");
////            while(rs.next()){
//////                while (++col <= colCount)
//////                {
////                    System.out.println(rs.getString("AllRooms"));
//////                }
////            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    public static int login(String username, String password){
        Connection connection = DBConnection.get_connection();

        String sql= "SELECT GetAvailableRooms('2024-10-22', '2024-10-24') as AllRooms";
        try {
            Statement stat = connection.createStatement();
//            PreparedStatement pstat = connection.prepareStatement(sql);
//            pstat.setString(1, username);
//            pstat.setString(2, password);
//            Statement statement = connection.createStatement();
            ResultSet rs =stat.executeQuery(sql);
            ResultSetMetaData resultSetMetaData =rs.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();
            String result = "";
            ObjectMapper om = new ObjectMapper();
            List<Room> rm = new ArrayList<>();
            while(rs.next()){
                result = rs.getString("AllRooms");
                rm = om.readValue(result, new TypeReference<List<Room>>() {
                });
                for (Room room : rm) {
                    System.out.println("Room Number: " + room.getRoomNumber());
                    System.out.println("Price: " + room.getPrice());
                    System.out.println("Prebooked: " + room.getPrebooked());
                    System.out.println("Room Type: " + room.getRoomType());
                    System.out.println();
                }
            }
//            if(colCount == 0)
//                return 0;
//            else
//                return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
}