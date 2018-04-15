package com.tecnoinfsanjose.tareaandroiduno.Vistas.Activities;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tecnoinfsanjose.tareaandroiduno.Vistas.Fragments.CancelarEmpleado;
import com.tecnoinfsanjose.tareaandroiduno.Vistas.Fragments.ConfirmarCliente;
import com.tecnoinfsanjose.tareaandroiduno.Vistas.Fragments.HomeCliente;
import com.tecnoinfsanjose.tareaandroiduno.Vistas.Fragments.HomeEmpleado;
import com.tecnoinfsanjose.tareaandroiduno.R;

public class ActivityHome extends AppCompatActivity implements IActivityHome {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        cargarHomeCliente();
    }

    @Override
    public void cargarHomeCliente() {
        HomeCliente nuevo = new HomeCliente();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
        fragmentTransaction.replace(R.id.frame_contenedor_home,nuevo);
        fragmentTransaction.commit();
    }

    @Override
    public void cargarHomeEmpleado() {
        HomeEmpleado nuevo = new HomeEmpleado();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
        fragmentTransaction.replace(R.id.frame_contenedor_home,nuevo);
        fragmentTransaction.commit();
    }

    @Override
    public void cambiarHomeAConfirmarCliente() {
        ConfirmarCliente nuevo = new ConfirmarCliente();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
        fragmentTransaction.replace(R.id.frame_contenedor_home,nuevo);
        fragmentTransaction.commit();
    }

    @Override
    public void cambiarHomeAConfirmarEmpleado() {
        CancelarEmpleado nuevo = new CancelarEmpleado();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
        fragmentTransaction.replace(R.id.frame_contenedor_home,nuevo);
        fragmentTransaction.commit();
    }

    @Override
    public void volverActivityInicio() {
        Intent intent = new Intent(ActivityHome.this , ActivityInicio.class);
        startActivity(intent);
    }


}
