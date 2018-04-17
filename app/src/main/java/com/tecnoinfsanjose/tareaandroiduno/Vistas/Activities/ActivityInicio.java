package com.tecnoinfsanjose.tareaandroiduno.Vistas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.tecnoinfsanjose.tareaandroiduno.DataTypes.ClienteDataType;
import com.tecnoinfsanjose.tareaandroiduno.DataTypes.EmpleadoDataType;
import com.tecnoinfsanjose.tareaandroiduno.Vistas.Fragments.ListaUsuarios;
import com.tecnoinfsanjose.tareaandroiduno.Vistas.Fragments.LogIn;
import com.tecnoinfsanjose.tareaandroiduno.R;
import com.tecnoinfsanjose.tareaandroiduno.Vistas.Fragments.Registrarse;

public class ActivityInicio extends AppCompatActivity implements IActivityInicio {


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
    public void cambiarLoginAListarUsuarios() {
        ListaUsuarios nuevo = new ListaUsuarios();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
        fragmentTransaction.replace(R.id.frame_contenedor,nuevo);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void moverseActivityHomeCliente(ClienteDataType c) {
        Intent intent = new Intent(ActivityInicio.this,ActivityHome.class);
        intent.putExtra("cliente",c);
        startActivity(intent);
    }
    @Override
    public void moverseActivityHomeEmpleado(EmpleadoDataType e){
        Intent intent = new Intent(ActivityInicio.this,ActivityHome.class);
        intent.putExtra("empleado",e);
        startActivity(intent);
    }
}
