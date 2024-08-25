package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Audit {
    @JsonProperty("audit_id")
    private int auditId;

    @JsonProperty("booking_id")
    private int bookingId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("contact")
    private String contact;

    @JsonProperty("id_proof")
    private String idProof;

    @JsonProperty("address")
    private String address;

    @JsonProperty("checkin")
    private String checkin;

    @JsonProperty("checkout")
    private String checkout;

    @JsonProperty("rooms")
    private String rooms;

    @JsonProperty("services_expense")
    private int servicesExpense;

    @JsonProperty("total_rent")
    private int totalRent;

    // No-argument constructor
    public Audit() {
    }

    // Parameterized constructor
    public Audit(int auditId, int bookingId, String name, String contact, String idProof,
                 String address, String checkin, String checkout, String rooms,
                 int servicesExpense, int totalRent) {
        this.auditId = auditId;
        this.bookingId = bookingId;
        this.name = name;
        this.contact = contact;
        this.idProof = idProof;
        this.address = address;
        this.checkin = checkin;
        this.checkout = checkout;
        this.rooms = rooms;
        this.servicesExpense = servicesExpense;
        this.totalRent = totalRent;
    }

    // Getters and Setters
    public int getAuditId() {
        return auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String idProof) {
        this.idProof = idProof;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public int getServicesExpense() {
        return servicesExpense;
    }

    public void setServicesExpense(int serviceExpense) {
        this.servicesExpense = serviceExpense;
    }

    public int getTotalRent() {
        return totalRent;
    }

    public void setTotalRent(int totalRent) {
        this.totalRent = totalRent;
    }
}

