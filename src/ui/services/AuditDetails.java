package ui.services;

import models.Customer;
import ui.helper.MessageDisplay;
import user.admin.Admin;
import user.admin.Admin_Interface;

import java.util.List;

public class AuditDetails {
    public void getAudit(){
        System.out.println("==================================");
        System.out.println("         Audit Details");
        System.out.println("==================================");

        Admin_Interface admin = new Admin();
        List<Customer> auditDetails = admin.get_audit_details();

        int i=1;
        MessageDisplay.showMessage("S. No.   Booking ID   Customer Name   Checkin Date   Checkout Date   Booking Date   Address   ID Proof   Contact   Status");
        for(Customer customer: auditDetails){
            System.out.println(i + "   " + customer.getBookingId() + "   " + customer.getCustomerName() + "   " + customer.getCheckIn() + "   " + customer.getCheckOut() + "   " + customer.getBookingDate() + "   " + customer.getAddress() + "   " + customer.getIdProof() + "   " + customer.getContact() + "   " + customer.getStatus() + "\n");
            i++;
        }
    }
}