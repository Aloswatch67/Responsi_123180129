package com.example.covid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid.R;
import com.example.covid.model.kasus.KasusResultsItem;

import java.util.ArrayList;

public class KasusAdapter extends RecyclerView.Adapter<KasusAdapter.ViewHolder>
{

    private ArrayList<KasusResultsItem> kasusItem = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<KasusResultsItem> items)
    {
        kasusItem.clear();
        kasusItem.addAll(items);
        notifyDataSetChanged();
    }

    public KasusAdapter(Context context)
    {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kasus,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.txt_tanggal.setText(kasusItem.get(position).getTanggal()+"");
        holder.txt_konfirm.setText("Terkonfimasi : "+ kasusItem.get(position).getCONFIRMATION()+"");
        holder.txt_sembuh.setText("Sembuh : "+ kasusItem.get(position).getConfirmationSelesai()+"");
        holder.txt_meninggal.setText("Meninggal : "+ kasusItem.get(position).getConfirmationMeninggal()+"");
    }

    @Override
    public int getItemCount()
    {
        return kasusItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txt_tanggal, txt_konfirm, txt_sembuh, txt_meninggal;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            txt_tanggal = itemView.findViewById(R.id.itemkasus_txt_tanggal);
            txt_konfirm = itemView.findViewById(R.id.itemkasus_txt_konfirm);
            txt_sembuh = itemView.findViewById(R.id.itemkasus_txt_sembuh);
            txt_meninggal = itemView.findViewById(R.id.itemkasus_txt_meninggal);
        }
    }
}
