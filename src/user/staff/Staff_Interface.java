package user.staff;

public interface Staff_Interface {
    int register(String name, String contact, String username, String password);
    int get_service();
    int add_customer_expense(String room);
}
