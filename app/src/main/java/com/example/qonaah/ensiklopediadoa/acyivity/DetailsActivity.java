package com.example.qonaah.ensiklopediadoa.acyivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qonaah.ensiklopediadoa.R;
import com.example.qonaah.ensiklopediadoa.model.Nama;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    private Nama nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        nama = (Nama) getIntent().getSerializableExtra("nama");

        TextView textViewNama  = (TextView) findViewById(R.id.text_title);
        assert textViewNama != null;
        textViewNama.setText(nama.getNama());

        TextView textViewKete  = (TextView) findViewById(R.id.text_keterangan);
        assert textViewKete != null;
        textViewKete.setText(nama.getKeterangan());

        ImageView imageView = (ImageView) findViewById(R.id.image_detail);
        Picasso.with(this).load(R.drawable.images).into(imageView);
    }
}
