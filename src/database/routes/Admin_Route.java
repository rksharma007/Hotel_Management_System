package database.routes;

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

    public List<Customer> get_customers(){
        List<Customer> active_customers = new ArrayList<>();

        //request to db

        return active_customers;
    }

    public List<Room> check_availability(String checkin, String checkout){
        List<Room> available_rooms = new ArrayList<>();



        return available_rooms;
    }

    public List<Customer> get_audit_table(){
        List<Customer> audit_customer = new ArrayList<>();



        return audit_customer;
    }

    // List of rooms booked under a customer
    public List<Room> get_room_details(String aadhar, String contact){
        List<Room> available_rooms = new ArrayList<>();

        //request to db

        return available_rooms;
    }

    public int pay_expenses(int room_number){

        return 1;
    }

    public int checkout_customer(String contact){
        return 1;
    }

    public int book_room(){
        //db request
        return 1;
    }
}
