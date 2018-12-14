package com.example.qis_rnd.neoly.ModelPostReq;

import com.google.gson.annotations.SerializedName;

public class PostKontak {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Post mKontak;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Post getKontak() {
        return mKontak;
    }
    public void setKontak(Post Kontak) {
        mKontak = Kontak;
    }
}
