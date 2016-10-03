package com.example.qonaah.ensiklopediadoa.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qonaah.ensiklopediadoa.R;
import com.example.qonaah.ensiklopediadoa.model.Shiroh;

import java.util.List;

/**
 * Created by Qona'ah on 9/30/2016.
 */

public class RecycleShirohAdapter extends RecyclerView.Adapter<RecycleShirohAdapter.MyViewHolder> {
    private List<Shiroh> shirohs;
    private onClickListener onClickListener;


    public RecycleShirohAdapter(List<Shiroh> shirohs) {this.shirohs = shirohs;}

    @Override
    public RecycleShirohAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shiroh, parent, false);
        return new MyViewHolder(itemView);
    }

    public void setOnClickListener(onClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }


    public interface onClickListener {
        void OnKlikListener(View view, int position);
    }

    @Override
    public void onBindViewHolder(RecycleShirohAdapter.MyViewHolder holder, int position) {
        Shiroh shiroh = shirohs.get(position);
        holder.textViewNamaSatu.setText(shiroh.getNama());
    }

    @Override
    public int getItemCount() {
        return shirohs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewNamaSatu;

        public MyViewHolder(View view) {
            super(view);
            textViewNamaSatu = (TextView) view.findViewById(R.id.text_satu);
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






