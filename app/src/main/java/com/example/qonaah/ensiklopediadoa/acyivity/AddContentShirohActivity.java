package com.example.qonaah.ensiklopediadoa.acyivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qonaah.ensiklopediadoa.R;
import com.example.qonaah.ensiklopediadoa.model.Shiroh;
import com.example.qonaah.ensiklopediadoa.service.DatabaseHelper;

public class AddContentShirohActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextNama;
    private EditText editTextKeterangan;
    private EditText editTextVideo;
    private Button buttonSimpan;
    private DatabaseHelper databaseHelper;
    private Shiroh shiroh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shiroh);
        databaseHelper = DatabaseHelper.getInstance(this);

        editTextVideo = (EditText) findViewById(R.id.edit_text_video_shiroh);
        editTextNama = (EditText) findViewById(R.id.edit_text_nama_shiroh);
        editTextKeterangan = (EditText) findViewById(R.id.edit_text_keterangan_shiroh);
        if (getIntent().getBooleanExtra("edit", false)) {
            shiroh = (Shiroh) getIntent().getSerializableExtra("shiroh");
            editTextVideo.setText(shiroh.getVideo());
            editTextKeterangan.setText(shiroh.getKeterangan());
            editTextNama.setText(shiroh.getNama());
        }

        buttonSimpan = (Button) findViewById(R.id.button_simpan_shiroh);
        assert buttonSimpan != null;
        buttonSimpan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == buttonSimpan.getId()) {
            if (getIntent().getBooleanExtra("edit", false)) {
                shiroh.setNama(editTextNama.getText().toString());
                shiroh.setKeterangan(editTextKeterangan.getText().toString());
                shiroh.setVideo(editTextVideo.getText().toString());

                int hasil = databaseHelper.ubahShiroh(shiroh);
                if (hasil != 0) {
                    Toast.makeText(AddContentShirohActivity.this, "DATA BERHASIL DI UBAH", Toast.LENGTH_SHORT).show();
                    finish();
                }
            } else {
                shiroh = new Shiroh();
                shiroh.setNama(editTextNama.getText().toString());
                shiroh.setKeterangan(editTextKeterangan.getText().toString());
                shiroh.setVideo(editTextVideo.getText().toString());

                int hasil = databaseHelper.simpanShiroh(shiroh);
                if (hasil != 0) {
                    Toast.makeText(AddContentShirohActivity.this, "DATA BERHASIL DI SIMPAN", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }
}
