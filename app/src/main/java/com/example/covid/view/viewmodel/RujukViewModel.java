package com.example.covid.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.covid.model.rujuk.RujukResponse;
import com.example.covid.model.rujuk.RujukResultsItem;
import com.example.covid.service.APImain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RujukViewModel extends ViewModel {

    private APImain apiMain;

    private MutableLiveData<ArrayList<RujukResultsItem>> listRujuk = new MutableLiveData<>();

    public void setFasilitasDiscover() {
        if(this.apiMain==null){
            apiMain = new APImain();
        }

        apiMain.getApiRujuk().getRujuk().enqueue(new Callback<RujukResponse>()
        {
            @Override
            public void onResponse(Call<RujukResponse> call, Response<RujukResponse> response)
            {
                RujukResponse fasilitasDiscover = response.body();
                if(fasilitasDiscover != null && fasilitasDiscover.getData() != null)
                {
                    ArrayList<RujukResultsItem> rujukResultsItems = fasilitasDiscover.getData();
                    listRujuk.postValue(rujukResultsItems);
                }
            }

            @Override
            public void onFailure(Call<RujukResponse> call, Throwable t)
            {

            }
        });
    }

    public LiveData<ArrayList<RujukResultsItem>> getRujukDiscover()
    {
        return listRujuk;
    }
}
