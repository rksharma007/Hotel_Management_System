import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.DBConnection;
import models.Customer;
import models.Response;
import models.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main{
    static Connection connection = DBConnection.get_connection();

    public static void main(String[] args) {
//        System.out.println(login("adminahuja", "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918"));
//        Connection connection = DBConnection.get_connection();
        login_me();
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
    public static void login_me(){
        List<Room> available_rooms = new ArrayList<>();

        String sql= "SELECT * FROM Booking Where contact=?;";
        try {
//            Statement stat = connection.createStatement();
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, "786");
            ResultSet rs =pstat.executeQuery();
            ResultSetMetaData resultSetMetaData =rs.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();
            if(colCount != 0){
                int booking_id=-1;
                while(rs.next()){
                    booking_id = rs.getInt("booking_id");
                }
                sql = "SELECT r.room_number as room_number, r.room_type as room_type, r.price as price, r.prebooked as prebooked FROM Room_Booking rb INNER JOIN Room r on rb.room_number = r.room_number WHERE rb.booking_id = ?";
                pstat = connection.prepareStatement(sql);
                pstat.setInt(1, booking_id);

                rs =pstat.executeQuery();
                resultSetMetaData =rs.getMetaData();
                colCount = resultSetMetaData.getColumnCount();

                while(rs.next()){
                    available_rooms.add(new Room(
                            rs.getInt("price"),
                            rs.getInt("prebooked"),
                            rs.getInt("room_type"),
                            rs.getInt("room_number")
                    ));
                }
                for(Room r: available_rooms){
                    System.out.println(r.getRoomNumber()+" "+r.getRoomType()+" "+r.getPrice()+" "+r.getPrebooked());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int login(String checkin, String checkout){
        Connection connection = DBConnection.get_connection();

        String sql= "SELECT GetAvailableRooms(?, ?) as AllRooms;";
        try {
//            Statement stat = connection.createStatement();
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, checkin);
            pstat.setString(2, checkout);
            System.out.println(pstat.toString());
//            Statement statement = connection.createStatement();
            ResultSet rs =pstat.executeQuery();
            ResultSetMetaData resultSetMetaData =rs.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();
            String result = "";
            ObjectMapper om = new ObjectMapper();
            List<Room> rm = new ArrayList<>();
            while(rs.next()){
                result = rs.getString("AllRooms");
                System.out.println(result);
//                Response s = om.readValue(result, Response.class);
//                System.out.println(s.getStatus()+" "+s.getMessage());
//                rm = om.readValue(result, new TypeReference<List<Room>>() {
//                });
//                for (Room room : rm) {
//                    System.out.println("Room Number: " + room.getRoomNumber());
//                    System.out.println("Price: " + room.getPrice());
//                    System.out.println("Prebooked: " + room.getPrebooked());
//                    System.out.println("Room Type: " + room.getRoomType());
//                    System.out.println();
//                }
            }
//            if(colCount == 0)
//                return 0;
//            else
//                return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        catch (JsonMappingException e) {
//            throw new RuntimeException(e);
//        }
//        catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
        return -1;
    }
}