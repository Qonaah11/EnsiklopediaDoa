package com.example.qonaah.ensiklopediadoa.acyivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.qonaah.ensiklopediadoa.R;

public class ActionShirohActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonHapus;
    private Button buttonTambah;
    private Button buttonUbah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_nama);

        buttonHapus = (Button) findViewById(R.id.button_hapus);
        assert buttonHapus != null;
        buttonHapus.setOnClickListener(this);

        buttonUbah = (Button) findViewById(R.id.button_ubah);
        assert buttonUbah != null;
        buttonUbah.setOnClickListener(this);

        buttonTambah = (Button) findViewById(R.id.button_add);
        assert buttonTambah != null;
        buttonTambah.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == buttonHapus.getId()){
            Intent intent = new Intent(this, HapusShirohActivity.class);
            startActivity(intent);
        }

        if (view.getId() == buttonUbah.getId()){
            startActivity(new Intent(this, UbahShirohActivity.class));
        }

        if (view.getId() == buttonTambah.getId()){
            Intent intent = new Intent(this, AddContentShirohActivity.class);
            intent.putExtra("edit", false);
            startActivity(intent);
        }
    }
}
