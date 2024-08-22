package database.routes;

import database.DBConnection;

import java.sql.Connection;

public class Admin_Route {
    private final Connection connection;

    public Admin_Route(){
        this.connection = DBConnection.connect();
    }
}
