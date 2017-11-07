package com.emt.hashtags;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mehdi on 28/10/2017.
 */

public class Profile {

    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("content")
    @Expose
    private String content;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("location")
    @Expose
    private String location;

    @SerializedName("saved")
    @Expose
    private Boolean isSaved;

    @SerializedName("image")
    @Expose
    private String image;

    public Profile(User user, String content, String date, String location, Boolean isSaved, String image) {
        this.user = user;
        this.content = content;
        this.date = date;
        this.location = location;
        this.isSaved = isSaved;
        this.image = image;
    }

    public Boolean isSaved() {
        return isSaved;
    }

    public void setSaved(Boolean saved) {
        isSaved = saved;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}