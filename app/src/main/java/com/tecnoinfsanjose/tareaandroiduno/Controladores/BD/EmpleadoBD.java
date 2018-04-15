package com.tecnoinfsanjose.tareaandroiduno.Controladores.BD;

import com.tecnoinfsanjose.tareaandroiduno.Modelos.Empleado;

import java.util.ArrayList;


public class EmpleadoBD {

    private ArrayList<Empleado> empleados;
    private static EmpleadoBD empleadoBD=null;

    public static EmpleadoBD getInstance(){
        if(empleadoBD == null){
            empleadoBD = new EmpleadoBD();
        }
        return empleadoBD;
    }
    private EmpleadoBD(){
        this.empleados=new ArrayList<>();
    }
    public ArrayList<Empleado> getEmpleados(){
        return this.empleados;
    }
    public void setEmpleado(Empleado e){
        this.empleados.add(e);
    }
}
