package com.example.covid.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.covid.R;
import com.example.covid.adapter.KasusAdapter;
import com.example.covid.model.kasus.KasusResultsItem;
import com.example.covid.view.viewmodel.KasusViewModel;

import java.util.ArrayList;

public class KasusFragment extends Fragment
{

    private KasusAdapter kasusAdapter;
    private RecyclerView recyclerviewKasus;
    private KasusViewModel kasusViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        kasusAdapter = new KasusAdapter(getContext());
        kasusAdapter.notifyDataSetChanged();

        recyclerviewKasus = view.findViewById(R.id.kasusharian_rv_main);
        recyclerviewKasus.setLayoutManager(new LinearLayoutManager(getContext()));

        kasusViewModel = new ViewModelProvider(this).get(KasusViewModel.class);
        kasusViewModel.setKasusDiscover();
        kasusViewModel.getKasusDiscover().observe(getViewLifecycleOwner() , getKasusDiscover);

        recyclerviewKasus.setAdapter(kasusAdapter);
    }

    private Observer<ArrayList<KasusResultsItem>> getKasusDiscover = new Observer<ArrayList<KasusResultsItem>>()
    {
        @Override
        public void onChanged(ArrayList<KasusResultsItem> kasusResultsItems)
        {
            if(kasusResultsItems != null)
            {
                kasusAdapter.setData(kasusResultsItems);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kasus, container, false);
    }

}