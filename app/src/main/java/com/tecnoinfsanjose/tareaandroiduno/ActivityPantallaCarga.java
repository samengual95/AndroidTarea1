package com.tecnoinfsanjose.tareaandroiduno;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityPantallaCarga extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_carga);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ActivityPantallaCarga.this , ActivityInicio.class);
                startActivity(intent);
                finish();
            }
        } , 3000);
    }
}