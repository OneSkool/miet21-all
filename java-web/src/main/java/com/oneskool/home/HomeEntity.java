package com.oneskool.home;

public class HomeEntity {
    private int id;
    private String message;
    private String details;

    public HomeEntity(int id, String message, String details) {
        this.id = id;
        this.message = message;
        this.details = details;
    }

    public int getId() {
        return id;
    }


    public String getMessage() {
        return message;
    }


    public String getDetails() {
        return details;
    }


}
