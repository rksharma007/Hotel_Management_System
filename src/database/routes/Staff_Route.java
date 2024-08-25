package database.routes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.DBConnection;
import models.Response;
import models.Service;

import java.io.IOException;
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

        String sql= "SELECT * FROM Staff WHERE staff_username=? and staff_password=?";
        try {
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1, username);
            pstat.setString(2, password);
            ResultSet rs =pstat.executeQuery();
            ResultSetMetaData resultSetMetaData =rs.getMetaData();
//            int colCount = resultSetMetaData.getColumnCount();
            int rowCount=0;
            while(rs.next())
                rowCount++;
            if(rowCount == 0)
                return 0;
            else
                return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //done
    public List<Service> get_services(){
        List<Service> services = new ArrayList<>();

        String sql= "SELECT * FROM Service";
        try {
            Statement stat = connection.createStatement();
            ResultSet rs =stat.executeQuery(sql);
            ResultSetMetaData resultSetMetaData =rs.getMetaData();

            while(rs.next()){
                services.add(new Service(
                        rs.getInt("service_id"),
                        rs.getString("service_name"),
                        rs.getInt("service_price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    //done, left to check
    public int add_expense(int room_number, int service_id){

        String sql= "SELECT AddExpense(?, ?) as expense;";
        try {
//            Statement stat = connection.createStatement();
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setInt(1, room_number);
            pstat.setInt(2, service_id);
            ResultSet rs =pstat.executeQuery();
            ResultSetMetaData resultSetMetaData =rs.getMetaData();
//            String result = "";
            Response r = null;
            while(rs.next()){
                r = obj_mapper.readValue(rs.getString("expense"), Response.class);
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