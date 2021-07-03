package com.example.covid.model.kasus;

import com.google.gson.annotations.SerializedName;

public class KasusResponse {

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("data")
    private Data data;

    public int getStatusCode(){
        return statusCode;
    }

    public Data getData(){
        return data;
    }

    @Override
    public String toString(){
        return
                "Response{" +
                        "status_code = '" + statusCode + '\'' +
                        ",data = '" + data + '\'' +
                        "}";
    }
}