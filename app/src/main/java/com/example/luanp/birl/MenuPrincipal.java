package com.example.luanp.birl;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuPrincipal extends AppCompatActivity {

    private ImageButton btexercicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_menu_principal);

        btexercicio = (ImageButton) findViewById(R.id.btexercicio);

        btexercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipal.this,SelecionaExercicio.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
