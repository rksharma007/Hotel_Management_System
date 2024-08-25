package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    @JsonProperty("booking_id")
    private int bookingId;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("check_in")
    private String checkIn;

    @JsonProperty("check_out")
    private String checkOut;

    @JsonProperty("booking_date")
    private String bookingDate;

    @JsonProperty("address")
    private String address;

    @JsonProperty("id_proof")
    private String idProof;

    @JsonProperty("contact")
    private String contact;

    @JsonProperty("status")
    private int status;

    // Default constructor (required for deserialization)
    public Customer() {}

    // Parameterized constructor (optional)
    public Customer(int bookingId, String checkIn, String checkOut, String bookingDate, String address, String customerName, String idProof, String contact, int status) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingDate = bookingDate;
        this.address = address;
        this.idProof = idProof;
        this.contact = contact;
        this.status=status;
    }

    // Getters and setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String idProof) {
        this.idProof = idProof;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getStatus(){
        return this.status;
    }

    public void setStatus(int status){
        this.status = status;
    }
}
