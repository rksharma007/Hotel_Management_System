package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Service {
    @JsonProperty("service_id")
    private int serviceId;

    @JsonProperty("service_name")
    private String serviceName;

    @JsonProperty("service_price")
    private int servicePrice;

    // Default constructor (required for deserialization)
    public Service() {}

    // Parameterized constructor (optional)
    public Service(int serviceId, String serviceName, int servicePrice) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
    }

    // Getters and setters
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }
}


