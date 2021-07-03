package com.example.covid.service;

import com.example.covid.model.kasus.KasusResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KasusRepository
{
    @GET("rekapitulasi_v2/jabar/kumulatif")
    Call<KasusResponse> getKasus();

}
