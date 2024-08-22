package Classes;

import Interfaces.Staff_Interface;
import Interfaces.User_Interface;

public class Staff implements User_Interface, Staff_Interface {
    private final String username;
    private final String password;

    public Staff(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public int get_service() {
        return 0;
    }

    @Override
    public int add_customer_expense() {
        return 0;
    }

    @Override
    public int login() {
        return 0;
    }

    @Override
    public int register() {
        return 0;
    }
}
