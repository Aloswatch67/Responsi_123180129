package com.example.covid.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.covid.model.kasus.KasusResultsItem;
import com.example.covid.model.kasus.KasusResponse;
import com.example.covid.service.APImain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KasusViewModel extends ViewModel
{

    private APImain apimain;
    private MutableLiveData<ArrayList<KasusResultsItem>> listKasus = new MutableLiveData<>();

    public void setKasusDiscover()
    {
        if(this.apimain ==null)
        {
            apimain = new APImain();
        }

        apimain.getApiKasus().getKasus().enqueue(new Callback<KasusResponse>()
        {
            @Override
            public void onResponse(Call<KasusResponse> call, Response<KasusResponse> response)
            {
                KasusResponse kasus_Respone = response.body();

                if(kasus_Respone != null && kasus_Respone.getData() != null)
                {
                    ArrayList<KasusResultsItem> kasusharianItem = kasus_Respone.getData().getContent();
                    listKasus.postValue(kasusharianItem);
                }
            }

            @Override
            public void onFailure(Call<KasusResponse> call, Throwable t)
            {

            }
        });
    }

    public LiveData<ArrayList<KasusResultsItem>> getKasusDiscover()
    {
        return listKasus;
    }
}
