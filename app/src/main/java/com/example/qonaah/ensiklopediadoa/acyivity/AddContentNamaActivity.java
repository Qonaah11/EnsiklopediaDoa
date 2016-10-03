package com.example.qonaah.ensiklopediadoa.acyivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qonaah.ensiklopediadoa.R;
import com.example.qonaah.ensiklopediadoa.model.Nama;
import com.example.qonaah.ensiklopediadoa.service.DatabaseHelper;

public class AddContentNamaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextNama;
    private EditText editTextKeterangan;
    private EditText editTextImage;
    private Button buttonSimpan;
    private DatabaseHelper databaseHelper;
    private Nama nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nama);
        databaseHelper = DatabaseHelper.getInstance(this);

        editTextImage = (EditText) findViewById(R.id.edit_text_image_nama);
        editTextNama = (EditText) findViewById(R.id.edit_text_nama_satu);
        editTextKeterangan = (EditText) findViewById(R.id.edit_text_keterangan_nama);
        if (getIntent().getBooleanExtra("edit", false)) {
            nama = (Nama) getIntent().getSerializableExtra("nama");
            editTextImage.setText(nama.getImage());
            editTextKeterangan.setText(nama.getKeterangan());
            editTextNama.setText(nama.getNama());
        }

        buttonSimpan = (Button) findViewById(R.id.button_simpan_nama);
        assert buttonSimpan != null;
        buttonSimpan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == buttonSimpan.getId()) {
            if (getIntent().getBooleanExtra("edit", false)) {
                nama.setNama(editTextNama.getText().toString());
                nama.setKeterangan(editTextKeterangan.getText().toString());
                nama.setImage(editTextImage.getText().toString());

                int hasil = databaseHelper.ubahNama(nama);
                if (hasil != 0) {
                    Toast.makeText(AddContentNamaActivity.this, "DATA BERHASIL DI UBAH", Toast.LENGTH_SHORT).show();
                    finish();
                }
            } else {
                nama = new Nama();
                nama.setNama(editTextNama.getText().toString());
                nama.setKeterangan(editTextKeterangan.getText().toString());
                nama.setImage(editTextImage.getText().toString());

                int hasil = databaseHelper.simpanNama(nama);
                if (hasil != 0) {
                    Toast.makeText(AddContentNamaActivity.this, "DATA BERHASIL DI SIMPAN", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }
}
