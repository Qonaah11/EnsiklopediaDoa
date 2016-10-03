package com.example.qonaah.ensiklopediadoa.acyivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.qonaah.ensiklopediadoa.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity {

    private CircleImageView imageViewSatu;
    private CircleImageView imageViewDua;
    private CircleImageView imageViewTiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewSatu = (CircleImageView) findViewById(R.id.image_satu);
        imageViewSatu.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 Intent intent = new Intent(MainActivity.this, SubShirohActivity.class);
                                                 startActivity(intent);


                                             }
                                         }

        );
        imageViewDua = (CircleImageView) findViewById(R.id.image_islam);
        imageViewDua.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubNamaActivity.class);
                startActivity(intent);
            }
        });

        imageViewTiga = (CircleImageView) findViewById(R.id.image_iman);
        imageViewTiga.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubDoaActivity.class);
                startActivity(intent);
            }
        });
    }
}






