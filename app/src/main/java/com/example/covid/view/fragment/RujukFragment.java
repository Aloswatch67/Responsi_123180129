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
import com.example.covid.adapter.RujukAdapter;
import com.example.covid.model.rujuk.RujukResultsItem;
import com.example.covid.view.viewmodel.RujukViewModel;

import java.util.ArrayList;

public class RujukFragment extends Fragment
{

    private RujukAdapter rujukAdapter;
    private RecyclerView recyclerviewRujuk;
    private RujukViewModel rujukViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        rujukAdapter = new RujukAdapter(getContext());
        rujukAdapter.notifyDataSetChanged();

        recyclerviewRujuk = view.findViewById(R.id.rujuk_rv_main);
        recyclerviewRujuk.setLayoutManager(new LinearLayoutManager(getContext()));

        rujukViewModel = new ViewModelProvider(this).get(RujukViewModel.class);
        rujukViewModel.setFasilitasDiscover();
        rujukViewModel.getRujukDiscover().observe(getViewLifecycleOwner() ,getFasilitasKesehatanDiscover);

        recyclerviewRujuk.setAdapter(rujukAdapter);
    }

    private Observer<ArrayList<RujukResultsItem>> getFasilitasKesehatanDiscover = new Observer<ArrayList<RujukResultsItem>>() {
        @Override
        public void onChanged(ArrayList<RujukResultsItem> rujukResultsItems)
        {
            if(rujukResultsItems != null)
            {
                rujukAdapter.setData(rujukResultsItems);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rujuk, container, false);
    }


}