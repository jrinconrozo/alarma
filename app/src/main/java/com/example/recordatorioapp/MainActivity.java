package com.example.recordatorioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = findViewById(R.id.imgift);

        String url = "https://cliply.co/wp-content/uploads/2020/03/422003720_CLOCK_3D_ICON_400px.gif";

        Uri urlparse = Uri.parse(url);
        Glide.with(getApplicationContext()).load(urlparse).into(imagen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(MainActivity.this, alarma.class);
                startActivity(i);

            }
        }, 5000);
    }
}