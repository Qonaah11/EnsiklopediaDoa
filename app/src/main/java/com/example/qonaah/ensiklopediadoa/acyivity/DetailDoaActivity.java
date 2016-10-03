package com.example.qonaah.ensiklopediadoa.acyivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.qonaah.ensiklopediadoa.R;
import com.example.qonaah.ensiklopediadoa.model.Hari;

/**
 * Created by Qona'ah on 9/30/2016.
 */

public class DetailDoaActivity extends AppCompatActivity {

    private Hari hari;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_doa);

        hari = (Hari) getIntent().getSerializableExtra("hari");
        TextView textViewKuning  = (TextView) findViewById(R.id.text_kuning);
        assert textViewKuning != null;
        textViewKuning.setText(hari.getNama());

        TextView taxtViewMerah  = (TextView) findViewById(R.id.text_merah);
        assert taxtViewMerah != null;
        taxtViewMerah.setText(hari.getKeterangan());

        TextView textViewHijau  = (TextView) findViewById(R.id.text_hijau);
        assert textViewHijau != null;
        textViewHijau.setText(hari.getImage());
    }
}
