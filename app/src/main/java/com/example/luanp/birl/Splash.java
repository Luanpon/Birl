package com.example.luanp.birl;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity implements Runnable{

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_splash);

        handler = new Handler();

        handler.postDelayed(this,100);


    }


    @Override
    public void run() {

        Intent intent = new Intent(this,MenuPrincipal.class);
        startActivity(intent);
        finish();

    }

}
