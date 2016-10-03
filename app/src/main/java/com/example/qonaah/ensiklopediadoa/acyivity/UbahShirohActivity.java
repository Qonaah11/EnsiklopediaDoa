package com.example.qonaah.ensiklopediadoa.acyivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.qonaah.ensiklopediadoa.R;
import com.example.qonaah.ensiklopediadoa.adapter.RecycleShirohAdapter;
import com.example.qonaah.ensiklopediadoa.model.Shiroh;
import com.example.qonaah.ensiklopediadoa.service.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qona'ah on 9/13/2016.
 */

public class UbahShirohActivity extends AppCompatActivity implements RecycleShirohAdapter.onClickListener {

    private RecyclerView recyclerView;
    private List<Shiroh> shirohs = new ArrayList<>();
    private DatabaseHelper databaseHelper;
    private RecycleShirohAdapter recycleShirohAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_shiroh);

        databaseHelper = DatabaseHelper.getInstance(this);
        shirohs = databaseHelper.selectShiroh();

        recycleShirohAdapter = new RecycleShirohAdapter(shirohs);
        recycleShirohAdapter.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_shiroh);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recycleShirohAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        shirohs = databaseHelper.selectShiroh();
        recycleShirohAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnKlikListener(View view, int position) {
        Intent intent = new Intent(this, AddContentShirohActivity.class);
        intent.putExtra("shiroh", shirohs.get(position));
        intent.putExtra("edit", true);
        startActivity(intent);
    }
}
