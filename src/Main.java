import database.DBConnection;
import ui.services.AdminLoginUI;
import ui.ui_layer.LoginUser;

import java.sql.*;

public class Main{
    static Connection connection = DBConnection.get_connection();

    public static void main(String[] args) {
        LoginUser newAdmin = new AdminLoginUI();
        newAdmin.loginRequester();
    }
}