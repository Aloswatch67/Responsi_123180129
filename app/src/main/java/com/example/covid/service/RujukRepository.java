package com.example.covid.service;

import com.example.covid.model.rujuk.RujukResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RujukRepository
{
    @GET("sebaran_v2/jabar/faskes")
    Call<RujukResponse> getRujuk();
}
