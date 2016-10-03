package com.example.qonaah.ensiklopediadoa.acyivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qonaah.ensiklopediadoa.R;
import com.example.qonaah.ensiklopediadoa.model.Hari;
import com.example.qonaah.ensiklopediadoa.service.DatabaseHelper;

public class AddContentActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextNama;
    private EditText editTextKeterangan;
    private EditText editTextImage;
    private Button buttonSimpan;
    private DatabaseHelper databaseHelper;
    private Hari hari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);
        databaseHelper = DatabaseHelper.getInstance(this);

        editTextImage = (EditText) findViewById(R.id.edit_text_image);
        editTextNama = (EditText) findViewById(R.id.edit_text_nama);
        editTextKeterangan = (EditText) findViewById(R.id.edit_text_keterangan);
        if (getIntent().getBooleanExtra("edit", false)) {
            hari = (Hari) getIntent().getSerializableExtra("hari");
            editTextImage.setText(hari.getImage());
            editTextKeterangan.setText(hari.getKeterangan());
            editTextNama.setText(hari.getNama());
        }

        buttonSimpan = (Button) findViewById(R.id.button_simpan);
        assert buttonSimpan != null;
        buttonSimpan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == buttonSimpan.getId()) {
            if (getIntent().getBooleanExtra("edit", false)) {
                hari.setNama(editTextNama.getText().toString());
                hari.setKeterangan(editTextKeterangan.getText().toString());
                hari.setImage(editTextImage.getText().toString());

                int hasil = databaseHelper.ubahDoa(hari);
                if (hasil != 0) {
                    Toast.makeText(AddContentActivity.this, "DATA BERHASIL DI UBAH", Toast.LENGTH_SHORT).show();
                    finish();
                }
            } else {
                hari = new Hari();
                hari.setNama(editTextNama.getText().toString());
                hari.setKeterangan(editTextKeterangan.getText().toString());
                hari.setImage(editTextImage.getText().toString());

                int hasil = databaseHelper.simpanDoa(hari);
                if (hasil != 0) {
                    Toast.makeText(AddContentActivity.this, "DATA BERHASIL DI SIMPAN", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }
}
