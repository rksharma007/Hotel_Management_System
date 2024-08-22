package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Room {
    @JsonProperty("price")
    private int price;

    @JsonProperty("prebooked")
    private int prebooked;

    @JsonProperty("room_type")
    private int roomType;

    @JsonProperty("room_number")
    private int roomNumber;

    // Default constructor (required for deserialization)
    public Room() {
    }

    // Parameterized constructor (optional)
    public Room(int price, int prebooked, int roomType, int roomNumber) {
        this.price = price;
        this.prebooked = prebooked;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
    }

    // Getters and setters
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrebooked() {
        return prebooked;
    }

    public void setPrebooked(int prebooked) {
        this.prebooked = prebooked;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
