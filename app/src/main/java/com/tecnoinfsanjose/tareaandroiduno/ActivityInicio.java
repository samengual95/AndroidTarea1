package com.tecnoinfsanjose.tareaandroiduno;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class ActivityInicio extends AppCompatActivity implements IActivityInicio{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        abrirLogin();
    }


    @Override
    public void abrirLogin(){
        LogIn nuevo = new LogIn();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
        fragmentTransaction.replace(R.id.frame_contenedor,nuevo);
        fragmentTransaction.commit();
    }

    @Override
    public void cambiarLoginARegistrarse() {
        Registrarse nuevo = new Registrarse();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
        fragmentTransaction.replace(R.id.frame_contenedor,nuevo);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void moverseActivityHome() {
        Intent intent = new Intent(ActivityInicio.this,ActivityHome.class);
        startActivity(intent);
    }
}
