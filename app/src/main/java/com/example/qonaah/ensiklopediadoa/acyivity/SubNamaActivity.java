package com.example.qonaah.ensiklopediadoa.acyivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.qonaah.ensiklopediadoa.R;
import com.example.qonaah.ensiklopediadoa.adapter.RecyclerNamaAdapter;
import com.example.qonaah.ensiklopediadoa.model.Nama;
import com.example.qonaah.ensiklopediadoa.service.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qona'ah on 9/13/2016.
 */

public class SubNamaActivity extends AppCompatActivity implements RecyclerNamaAdapter.onClickListener, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private List<Nama> namas = new ArrayList<>();
    private DatabaseHelper databaseHelper;
    private RecyclerNamaAdapter recyclerNamaAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_nam);

        databaseHelper = DatabaseHelper.getInstance(this);
        namas = databaseHelper.selectNama();

        recyclerNamaAdapter = new RecyclerNamaAdapter(namas);
        recyclerNamaAdapter.setOnClickListener(this);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swif_refresh);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_nama);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recyclerNamaAdapter);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        if (floatingActionButton != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(SubNamaActivity.this, ActionNamaActivity.class));
                }
            });
        }
    }

    @Override
    public void OnKlikListener(View view, int position) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("nama", namas.get(position));
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        if (namas.size() != 0) {
            namas.clear();
        }

        namas = databaseHelper.selectNama();
        recyclerNamaAdapter.notifyDataSetChanged();

        new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }.start();
    }
}
