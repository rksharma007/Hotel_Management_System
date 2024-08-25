package ui.services;

import models.Audit;
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
        List<Audit> auditDetails = admin.get_audit_details();

        MessageDisplay.showMessage("Audit ID   Booking ID   Customer Name   Checkin Date   Checkout Date   Booking Date   Address   ID Proof   Contact   Status");
        for(Audit customer: auditDetails){
            System.out.println(
                    customer.getAuditId() + "   "
                    + customer.getBookingId() + "   "
                    + customer.getName() + "   "
                    + customer.getContact() + "   "
                    + customer.getIdProof() + "   "
                    + customer.getAddress() + "   "
                    + customer.getCheckin() + "   "
                    + customer.getCheckout() + "   "
                    + customer.getRooms() + "   "
                    + customer.getServicesExpense() + "   "
                    + customer.getTotalRent() + "\n");
        }
    }
}