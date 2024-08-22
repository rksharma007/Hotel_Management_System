package Classes;

import Interfaces.Admin_Interface;
import Interfaces.User_Interface;
import Server.Admin_Route;

public class Admin implements User_Interface, Admin_Interface {
    private final String username;
    private final String password;

    public Admin(String username, String password){
        this.username = username;
        this.password = password;
    }

    public int login(){
        //logic for login
        return 1;
    }
    public int register(){
        //logic for register
        return 1;
    }

    @Override
    public int get_customer_details() {
        return 0;
    }

    @Override
    public int get_audit_details() {
        return 0;
    }

    @Override
    public int book_customer() {
        return 0;
    }

    @Override
    public int check_in_customer() {
        return 0;
    }

    @Override
    public int check_out_customer() {
        return 0;
    }

    @Override
    public int pay_expense() {
        return 0;
    }

    @Override
    public int approve_request() {
        return 0;
    }
}
