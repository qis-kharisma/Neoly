package com.example.qis_rnd.neoly.model.models;


import com.google.gson.annotations.SerializedName;

public class PreSpecialty {

    @SerializedName("actor")
    private String actor;

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
