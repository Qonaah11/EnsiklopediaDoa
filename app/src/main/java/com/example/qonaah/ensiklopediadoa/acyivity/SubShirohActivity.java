package com.example.qonaah.ensiklopediadoa.acyivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.qonaah.ensiklopediadoa.R;
import com.example.qonaah.ensiklopediadoa.adapter.RecycleShirohAdapter;
import com.example.qonaah.ensiklopediadoa.model.Shiroh;
import com.example.qonaah.ensiklopediadoa.service.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qona'ah on 9/13/2016.
 */

public class SubShirohActivity extends AppCompatActivity implements RecycleShirohAdapter.onClickListener {

    private RecyclerView recyclerView;
    private List<Shiroh> shirohs = new ArrayList<>();
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_shiro);

        databaseHelper = DatabaseHelper.getInstance(this);
        shirohs = databaseHelper.selectShiroh();

        RecycleShirohAdapter recycleShirohAdapter = new RecycleShirohAdapter(shirohs);
        recycleShirohAdapter.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_satu);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recycleShirohAdapter);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        if (floatingActionButton != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(SubShirohActivity.this, ActionShirohActivity.class));
                }
            });
        }
    }

    @Override
    public void OnKlikListener(View view, int position) {
        Intent intent = new Intent(this, DetailShirohActivity.class);
        intent.putExtra("shiroh", shirohs.get(position));
        startActivity(intent);
    }
}
