package database.routes;

import database.DBConnection;
import models.Customer;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Admin_Route {
    private final Connection connection;

    public Admin_Route(){
        this.connection = DBConnection.connect();
    }

    public static List<Customer> get_customers(){
        List<Customer> customers = new ArrayList<>();
        return customers;
    }

    public static int is_exist(String username, String password){
        return 1;
    }

    public int check_availability(String checkin, String checkout){
        return 1;
    }
}
