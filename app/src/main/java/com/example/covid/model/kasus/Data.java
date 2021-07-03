package com.example.covid.model.kasus;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Data{

    @SerializedName("metadata")
    private Metadata metadata;

    @SerializedName("content")
    private ArrayList<KasusResultsItem> content;

    public Metadata getMetadata(){
        return metadata;
    }

    public ArrayList<KasusResultsItem> getContent(){
        return content;
    }

    @Override
    public String toString(){
        return
                "Data{" +
                        "metadata = '" + metadata + '\'' +
                        ",content = '" + content + '\'' +
                        "}";
    }
}