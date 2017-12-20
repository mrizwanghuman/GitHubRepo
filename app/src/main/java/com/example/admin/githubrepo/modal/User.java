package com.example.admin.githubrepo.modal;

/**
 * Created by  Admin on 12/19/2017.
 */

public class User {
    String name;
    String imageUrl;
    String location;
    String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String name, String imageUrl, String location, String email) {

        this.name = name;
        this.imageUrl = imageUrl;
        this.location = location;
        this.email = email;
    }
}
