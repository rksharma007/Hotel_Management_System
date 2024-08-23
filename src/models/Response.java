package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    @JsonProperty("status")
    String status;
    @JsonProperty("message")
    String message;

    public Response(){}

    public Response(String status, String message){
        this.status=status;
        this.message=message;
    }

    public String getStatus(){
        return this.status;
    }
    public String getMessage(){
        return this.message;
    }
}
