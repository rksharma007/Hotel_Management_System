package user.staff;

import models.Service;

import java.util.List;

public interface Staff_Interface {
    List<Service> get_service();
    int add_customer_expense(int room_no, int service_id);
}
