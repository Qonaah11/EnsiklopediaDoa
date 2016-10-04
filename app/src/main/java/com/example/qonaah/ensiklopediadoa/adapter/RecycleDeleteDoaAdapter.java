package com.example.qonaah.ensiklopediadoa.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qonaah.ensiklopediadoa.R;
import com.example.qonaah.ensiklopediadoa.model.Hari;

import java.util.List;


/**
 * Created by qonaah on 9/10/16.
 */

public class RecycleDeleteDoaAdapter extends RecyclerView.Adapter<RecycleDeleteDoaAdapter.MyViewHolder> {

    private List<Hari> haris;
    private onClickListener onClickListener;

    public RecycleDeleteDoaAdapter(List<Hari> haris) {
        this.haris = haris;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ubah_doa, parent, false);
        return new MyViewHolder(itemView);
    }

    public void setOnClickListener(onClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface onClickListener {
        void OnKlikListener(View view, int position);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Hari hari = haris.get(position);
        holder.textViewNama.setText(hari.getNama());
    }

    @Override
    public int getItemCount() {
        return haris.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewNama;

        public MyViewHolder(View view) {
            super(view);
            textViewNama = (TextView) view.findViewById(R.id.text_nama_doa);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onClickListener != null){
                onClickListener.OnKlikListener(v, getAdapterPosition());
            }
        }
    }
}
