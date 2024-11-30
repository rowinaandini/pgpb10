package com.example.retrofit;

import com.google.gson.annotations.SerializedName;
import java.util.List;
public class Users {
    @SerializedName("data")
    private List<com.example.retrofit.model.Data> data;

    public List<com.example.retrofit.model.Data> getData(){
        return data;
    }
}
