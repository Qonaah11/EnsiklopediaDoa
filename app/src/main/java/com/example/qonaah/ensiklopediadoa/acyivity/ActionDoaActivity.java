package com.example.qonaah.ensiklopediadoa.acyivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.qonaah.ensiklopediadoa.R;

public class ActionDoaActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonHapus;
    private Button buttonTambah;
    private Button buttonUbah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_doa);

        buttonHapus = (Button) findViewById(R.id.button_hapus_doa);
        assert buttonHapus != null;
        buttonHapus.setOnClickListener(this);

        buttonUbah = (Button) findViewById(R.id.button_ubah_doa);
        assert buttonUbah != null;
        buttonUbah.setOnClickListener(this);

        buttonTambah = (Button) findViewById(R.id.button_add_doa);
        assert buttonTambah != null;
        buttonTambah.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == buttonHapus.getId()){
            Intent intent = new Intent(this, HapusDoaActivity.class);
            startActivity(intent);
        }

        if (view.getId() == buttonUbah.getId()){
            startActivity(new Intent(this, UbahDoaActivity.class));
        }

        if (view.getId() == buttonTambah.getId()){
            Intent intent = new Intent(this, AddContentActivity.class);
            intent.putExtra("edit", false);
            startActivity(intent);
        }
    }
}
