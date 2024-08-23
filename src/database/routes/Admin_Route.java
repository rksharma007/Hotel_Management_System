package database.routes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.DBConnection;
import models.Customer;
import models.Response;
import models.Room;

import java.io.IOException;
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
    //output: 1- exists, 0 - doesn't exists, -1 - server error
    public int login(String username, String password){
        Connection connection = DBConnection.get_connection();

        String sql= "SELECT * FROM Admin WHERE admin_username=? and admin_password=?";
        try {
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, username);
            pstat.setString(2, password);
            ResultSet rs =pstat.executeQuery();
            ResultSetMetaData resultSetMetaData =rs.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();
//            System.out.println(colCount);
            if(colCount == 0)
                return 0;
            else
                return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //done
    public List<Customer> get_customers(){
        List<Customer> active_customers = new ArrayList<>();

        String sql= "SELECT * FROM Booking Where status = 1;";
        try {
            Statement stat = connection.createStatement();
            ResultSet rs =stat.executeQuery(sql);
            ResultSetMetaData resultSetMetaData =rs.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();
            String result = "";
            while(rs.next()){
                active_customers.add(new Customer(
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
            while(rs.next()){
                result = rs.getString("AllRooms");
                available_rooms = obj_mapper.readValue(result, new TypeReference<List<Room>>() {
                });
            }
            return available_rooms;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
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

    // done
    public int pay_expenses(int room_number){

        String sql= "SELECT ClearExpense(?) as expense;";
        try {
//            Statement stat = connection.createStatement();
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setInt(1, room_number);
            ResultSet rs =pstat.executeQuery();
            ResultSetMetaData resultSetMetaData =rs.getMetaData();
            String result = "";
            Response r = null;
            while(rs.next()){
                r = obj_mapper.readValue(rs.getString("expense"), Response.class);
            }
            return r.getStatus().equals("success") ? 1 : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    //done, left to check
    public int checkin_customer(String aadhar, String contact){

        String sql= "SELECT checkin(?, ?) as checkin;";
        try {
//            Statement stat = connection.createStatement();
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, contact);
            pstat.setString(2, aadhar);
            ResultSet rs =pstat.executeQuery();
            ResultSetMetaData resultSetMetaData =rs.getMetaData();
            String result = "";
            Response r = null;
            while(rs.next()){
                r = obj_mapper.readValue(rs.getString("checkin"), Response.class);
            }
            return r.getStatus().equals("success") ? 1 : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    //done, left to check
    public int checkout_customer(String contact){
        String sql= "SELECT Checkout2(?) as checkout;";
        try {
//            Statement stat = connection.createStatement();
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, contact);
            ResultSet rs =pstat.executeQuery();
            ResultSetMetaData resultSetMetaData =rs.getMetaData();
            String result = "";
            Response r = null;
            while(rs.next()){
                r = obj_mapper.readValue(rs.getString("checkout"), Response.class);
            }
            return r.getStatus().equals("success") ? 1 : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    //done, left to check
    public int book_room(String checkin_date, String checkout_date, String address, String name, String contact, int count_normal, int count_deluxe){

        String sql= "SELECT RoomBooking(?, ?, ?, ?, ?, ?, ?) as booking;";
        try {
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, checkin_date);
            pstat.setString(2, checkout_date);
            pstat.setString(3, address);
            pstat.setString(4, name);
            pstat.setString(5, contact);
            pstat.setInt(6, count_normal);
            pstat.setInt(7, count_deluxe);
            ResultSet rs =pstat.executeQuery();
            ResultSetMetaData resultSetMetaData =rs.getMetaData();
            String result = "";
            Response r = null;
            while(rs.next()){
                r = obj_mapper.readValue(rs.getString("booking"), Response.class);
            }
            return r.getStatus().equals("success") ? 1 : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    //done
    public int register_staff(String name, String contact, String username, String password){
//        String name="test_staff";
//        String contact="1234";
//        String username="test";
//        String password="9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08";
        String sql= "SELECT * FROM Staff Where staff_contact = ?";
        try {
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, contact);
            ResultSet rs =pstat.executeQuery();
            ResultSetMetaData resultSetMetaData =rs.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();
            if(colCount != 0){
                sql= "INSERT INTO Staff(staff_name, staff_contact, staff_username, staff_password) VALUES ( ? , ? , ? , ? );";
                pstat = connection.prepareStatement(sql);
                pstat.setString(1, name);
                pstat.setString(2, contact);
                pstat.setString(3, username);
                pstat.setString(4, password);
                if(pstat.executeUpdate() > 0)
                    return 1;
                else return -1;
            } else return 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }

    // done, left to check
    public int cancel_booking(String contact){
        String sql= "SELECT CancelBooking(?) as cancel;";
        try {
//            Statement stat = connection.createStatement();
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, contact);
            ResultSet rs =pstat.executeQuery();
            ResultSetMetaData resultSetMetaData =rs.getMetaData();
            String result = "";
            Response r = null;
            while(rs.next()){
                r = obj_mapper.readValue(rs.getString("cancel"), Response.class);
            }
            return r.getStatus().equals("success") ? 1 : 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
}
