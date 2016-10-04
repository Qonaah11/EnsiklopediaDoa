package com.example.qonaah.ensiklopediadoa.acyivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.qonaah.ensiklopediadoa.R;
import com.example.qonaah.ensiklopediadoa.adapter.RecycleDoaAdapter;
import com.example.qonaah.ensiklopediadoa.model.Hari;
import com.example.qonaah.ensiklopediadoa.service.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qona'ah on 9/13/2016.
 */

public class UbahDoaActivity extends AppCompatActivity implements RecycleDoaAdapter.onClickListener {

    private RecyclerView recyclerView;
    private List<Hari> haris = new ArrayList<>();
    private DatabaseHelper databaseHelper;
    private RecycleDoaAdapter recycleDoaActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_doa);

        databaseHelper = DatabaseHelper.getInstance(this);
        haris = databaseHelper.selectDoa();

        recycleDoaActivity = new RecycleDoaAdapter(haris);
        recycleDoaActivity.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_doa);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recycleDoaActivity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        haris = databaseHelper.selectDoa();
        recycleDoaActivity.notifyDataSetChanged();
    }

    @Override
    public void OnKlikListener(View view, int position) {
        Intent intent = new Intent(this, AddContentActivity.class);
        intent.putExtra("hari", haris.get(position));
        intent.putExtra("edit", true);
        startActivity(intent);
    }
}
