package database.routes;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.DBConnection;
import models.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Staff_Route {
    ObjectMapper obj_mapper;
    Connection connection;

    public Staff_Route(){
        this.obj_mapper = new ObjectMapper();
        this.connection = DBConnection.get_connection();
    }

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

    public List<Service> get_services(){
        List<Service> services = new ArrayList<>();

        //procedure

        return services;
    }
    public int add_expense(String room_number, int service_id){

        // procedure (room, service)

        return 1;
    }
}