package com.example.qonaah.ensiklopediadoa.acyivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class UbahNamaActivity extends AppCompatActivity implements RecyclerNamaAdapter.onClickListener {

    private RecyclerView recyclerView;
    private List<Nama> namas = new ArrayList<>();
    private DatabaseHelper databaseHelper;
    private RecyclerNamaAdapter recyclerNamaAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_nama);

        databaseHelper = DatabaseHelper.getInstance(this);
        namas = databaseHelper.selectNama();

        recyclerNamaAdapter = new RecyclerNamaAdapter(namas);
        recyclerNamaAdapter.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_nama);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recyclerNamaAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        namas = databaseHelper.selectNama();
        recyclerNamaAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnKlikListener(View view, int position) {
        Intent intent = new Intent(this, AddContentNamaActivity.class);
        intent.putExtra("nama", namas.get(position));
        intent.putExtra("edit", true);
        startActivity(intent);
    }
}
