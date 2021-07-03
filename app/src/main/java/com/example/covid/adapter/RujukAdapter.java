package com.example.covid.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid.R;
import com.example.covid.model.rujuk.RujukResultsItem;

import java.util.ArrayList;

public class RujukAdapter extends RecyclerView.Adapter<RujukAdapter.ViewHolder>
{
    private ArrayList<RujukResultsItem> rujukResultsItems = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<RujukResultsItem> items)
    {
        rujukResultsItems.clear();
        rujukResultsItems.addAll(items);
        notifyDataSetChanged();
    }

    public RujukAdapter(Context context)
    {
        this.context = context;
    }

    @NonNull
    @Override
    public RujukAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rujuk,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RujukAdapter.ViewHolder holder, int position)
    {
        holder.txt_nama.setText(rujukResultsItems.get(position).getNama());
        holder.txt_alamat.setText(rujukResultsItems.get(position).getAlamat());
        holder.btn_maps.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q="+
                        rujukResultsItems.get(position).getAlamat()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return rujukResultsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txt_nama, txt_alamat;
        Button btn_maps;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            txt_nama = itemView.findViewById(R.id.itemrujuk_txt_nama);
            txt_alamat = itemView.findViewById(R.id.itemrujuk_txt_alamat);
            btn_maps = itemView.findViewById(R.id.itemrujuk_btn_map);
        }
    }
}
