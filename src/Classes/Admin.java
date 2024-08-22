package Classes;

import Interfaces.Users;

public class Admin implements Users {
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
}
