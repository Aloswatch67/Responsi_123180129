package com.example.covid.model.rujuk;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class RujukResponse {

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("data")
    private ArrayList<RujukResultsItem> data;

    public void setStatusCode(int statusCode){
        this.statusCode = statusCode;
    }

    public int getStatusCode(){
        return statusCode;
    }

    public void setData(ArrayList<RujukResultsItem> data){
        this.data = data;
    }

    public ArrayList<RujukResultsItem> getData(){
        return data;
    }
}