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
import com.example.qonaah.ensiklopediadoa.adapter.RecycleDeleteDoaAdapter;
import com.example.qonaah.ensiklopediadoa.model.Hari;
import com.example.qonaah.ensiklopediadoa.service.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qona'ah on 9/13/2016.
 */

public class HapusDoaActivity extends AppCompatActivity implements RecycleDeleteDoaAdapter.onClickListener {

    private RecyclerView recyclerView;
    private List<Hari> haris = new ArrayList<>();
    private DatabaseHelper databaseHelper;
    private RecycleDeleteDoaAdapter recycleDeleteDoaAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus_doa);

        databaseHelper = DatabaseHelper.getInstance(this);
        haris = databaseHelper.selectDoa();

        recycleDeleteDoaAdapter = new RecycleDeleteDoaAdapter(haris);
        recycleDeleteDoaAdapter.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_doa);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recycleDeleteDoaAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        haris = databaseHelper.selectDoa();
        recycleDeleteDoaAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnKlikListener(View view, final int position) {
        new AlertDialog.Builder(this).setMessage("Yakin akan menghapus data ini ?")
                .setPositiveButton("YA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        boolean result = databaseHelper.hapusDoa(haris.get(position));
                        if(result){
                            Toast.makeText(HapusDoaActivity.this, "Data Berhasil dihapus", Toast.LENGTH_SHORT).show();
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
