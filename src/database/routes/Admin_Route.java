package database.routes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.DBConnection;
import models.Customer;
import models.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Admin_Route {
    private final Connection connection;
    private ObjectMapper obj_mapper;

    public Admin_Route(){
        this.connection = DBConnection.get_connection();
        this.obj_mapper = new ObjectMapper();
    }
    //output: 1- exists, 0 - doesnt exists, -1 - server error
    public int login(String username, String password){
        Connection connection = DBConnection.get_connection();

        String sql= "SELECT * FROM Admin WHERE admin_username='"+username+"' and admin_password='"+password+"'";
        try {
            Statement stat = connection.createStatement();
            ResultSet rs =stat.executeQuery(sql);
            ResultSetMetaData resultSetMetaData =rs.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();
            if(colCount == 0)
                return 0;
            else
                return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //left
    public List<Customer> get_customers(){
        List<Customer> active_customers = new ArrayList<>();

        //request to db

        return active_customers;
    }

    //done
    public List<Room> check_availability(String checkin, String checkout){
        List<Room> available_rooms = new ArrayList<>();

        String sql= "SELECT GetAvailableRooms(?, ?) as AllRooms;";
        try {
//            Statement stat = connection.createStatement();
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, checkin);
            pstat.setString(2, checkout);
            ResultSet rs =pstat.executeQuery();
            ResultSetMetaData resultSetMetaData =rs.getMetaData();
//            int colCount = resultSetMetaData.getColumnCount();
            String result = "";
            ObjectMapper om = new ObjectMapper();
            while(rs.next()){
                result = rs.getString("AllRooms");
                available_rooms = om.readValue(result, new TypeReference<List<Room>>() {
                });
            }
            return available_rooms;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return available_rooms;
    }

    // done
    public List<Customer> get_audit_table(){
        List<Customer> audit_customer = new ArrayList<>();

        String sql= "SELECT * FROM Booking Where status = 2;";
        try {
            Statement stat = connection.createStatement();
            ResultSet rs =stat.executeQuery(sql);
            ResultSetMetaData resultSetMetaData =rs.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();
            String result = "";
            while(rs.next()){
                audit_customer.add(new Customer(
                        rs.getInt("booking_id"),
                        rs.getString("check_in"),
                        rs.getString("check_out"),
                        rs.getString("booking_date"),
                        rs.getString("address"),
                        rs.getString("booking_id"),
                        rs.getString("booking_id"),
                        rs.getString("booking_id"),
                        rs.getInt("status")
                ));
            }
            return audit_customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return audit_customer;
    }

    // List of rooms booked under a customer, done
    public List<Room> get_room_details(String contact){
        List<Room> available_rooms = new ArrayList<>();

        String sql= "SELECT * FROM Booking Where contact=?;";
        try {
//            Statement stat = connection.createStatement();
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, contact);
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

//                while(rs.next()){
//                    available_rooms.add(new Room(
//                            rs.getInt("price"),
//                            rs.getInt("prebooked"),
//                            rs.getInt("room_type"),
//                            rs.getInt("room_number")
//                    ));
//                }
//                for(Room r: available_rooms){
//                    System.out.println(r.getRoomNumber()+" "+r.getRoomType()+" "+r.getPrice()+" "+r.getPrebooked());
//                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return available_rooms;
    }

    public int pay_expenses(int room_number){

        return 1;
    }

    public int checkout_customer(String contact){
        return 1;
    }

    public int book_room(String check_in, String check_out, String address, String cust_name, String contact, int cnt1, int cnt2){
        //db request
        return 1;
    }

    public int checkin_customer(String adhaar,String contact){
        return 1;
    }

    public int register_staff(String name,String contact,String username,String password){
        return 1;
    }

    public int cancel_booking(String contact){
        return 1;
    }
}