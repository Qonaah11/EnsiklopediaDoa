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
import com.example.qonaah.ensiklopediadoa.adapter.RecyclerDeleteNamaAdapter;
import com.example.qonaah.ensiklopediadoa.model.Nama;
import com.example.qonaah.ensiklopediadoa.service.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qona'ah on 9/13/2016.
 */

public class HapusNamaActivity extends AppCompatActivity implements RecyclerDeleteNamaAdapter.onClickListener {

    private RecyclerView recyclerView;
    private List<Nama> namas = new ArrayList<>();
    private DatabaseHelper databaseHelper;
    private RecyclerDeleteNamaAdapter recyclerDeleteNamaAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus_nama);

        databaseHelper = DatabaseHelper.getInstance(this);
        namas = databaseHelper.selectNama();

        recyclerDeleteNamaAdapter = new RecyclerDeleteNamaAdapter(namas);
        recyclerDeleteNamaAdapter.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_nama);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recyclerDeleteNamaAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        namas = databaseHelper.selectNama();
        recyclerDeleteNamaAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnKlikListener(View view, final int position) {
        new AlertDialog.Builder(this).setMessage("Yakin akan menghapus data ini ?")
                .setPositiveButton("YA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        boolean result = databaseHelper.hapusNama(namas.get(position));
                        if(result){
                            Toast.makeText(HapusNamaActivity.this, "Data Berhasil dihapus", Toast.LENGTH_SHORT).show();
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
