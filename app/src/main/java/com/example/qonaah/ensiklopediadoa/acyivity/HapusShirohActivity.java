package com.example.qonaah.ensiklopediadoa.acyivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.qonaah.ensiklopediadoa.R;
import com.example.qonaah.ensiklopediadoa.adapter.RecycleDeleteShirohAdapter;
import com.example.qonaah.ensiklopediadoa.model.Shiroh;
import com.example.qonaah.ensiklopediadoa.service.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qona'ah on 9/13/2016.
 */

public class HapusShirohActivity extends AppCompatActivity implements RecycleDeleteShirohAdapter.onClickListener {

    private RecyclerView recyclerView;
    private List<Shiroh> shirohs = new ArrayList<>();
    private DatabaseHelper databaseHelper;
    private RecycleDeleteShirohAdapter recycleShirohAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus_shiroh);

        databaseHelper = DatabaseHelper.getInstance(this);
        shirohs = databaseHelper.selectShiroh();

        recycleShirohAdapter = new RecycleDeleteShirohAdapter(shirohs);
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
    public void OnKlikListener(View view, final int position) {
        new AlertDialog.Builder(this).setMessage("Yakin akan menghapus data ini ?")
                .setPositiveButton("YA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        boolean result = databaseHelper.hapusShiroh(shirohs.get(position));
                        if (result) {
                            Toast.makeText(HapusShirohActivity.this, "Data Berhasil dihapus", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }
}
