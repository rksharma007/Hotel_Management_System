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
        int us_len = username.length();
        int pas_len = password.length();
        return 1;
    }
    public int register(){
        //logic for register
        return 1;
    }
}
