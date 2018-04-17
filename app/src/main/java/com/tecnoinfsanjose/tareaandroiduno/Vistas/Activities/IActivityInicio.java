package com.tecnoinfsanjose.tareaandroiduno.Vistas.Activities;


import com.tecnoinfsanjose.tareaandroiduno.DataTypes.ClienteDataType;
import com.tecnoinfsanjose.tareaandroiduno.DataTypes.EmpleadoDataType;

public interface IActivityInicio {

    public void abrirLogin();

    public void cambiarLoginARegistrarse();

    public void cambiarLoginAListarUsuarios();

    public void moverseActivityHomeCliente(ClienteDataType c);

    public void moverseActivityHomeEmpleado(EmpleadoDataType e);
}
