package com.example.qonaah.ensiklopediadoa.acyivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.qonaah.ensiklopediadoa.R;

/**
 * Created by Qona'ah on 9/30/2016.
 */

public class DetailShirohActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_shiroh);

        webView = (WebView) findViewById(R.id.webview);
        String playVideo= "<iframe src=\"http://www.youtube.com/embed/?listType=user_uploads&list=bayuekomoektito1\" width=\"480\" height=\"400\"></iframe>   ";
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(playVideo, "text/html", "utf-8");
    }
}
