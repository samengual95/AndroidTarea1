package com.tecnoinfsanjose.tareaandroiduno.Controladores.DAOs;

import com.tecnoinfsanjose.tareaandroiduno.Controladores.BD.EmpleadoBD;
import com.tecnoinfsanjose.tareaandroiduno.DataTypes.EmpleadoDataType;
import com.tecnoinfsanjose.tareaandroiduno.Modelos.Empleado;

import java.util.Iterator;


public class EmpleadoDAO {

    private EmpleadoBD empleadoBD;

    public void altaEmpleado(Empleado e){

        empleadoBD.setEmpleado(e);
    }

    public void modEmpleado(Empleado e){
        //Modificar Empleado e
    }
    public void bajaEmpleado(Empleado e){
        //Eliminar Empleado e
    }

    public Boolean buscarEmpleado(String mail){
        Iterator iterator = empleadoBD.getEmpleados().iterator();
        while(iterator.hasNext()){
            Empleado c = (Empleado) iterator.next();
            if(c.getEmail().equals(mail))
                return true;
        }
        return false;
    }
    public EmpleadoDataType datosEmpleadp(String mail){
        Iterator iterator = empleadoBD.getEmpleados().iterator();
        while(iterator.hasNext()){
            Empleado c = (Empleado) iterator.next();
            if(c.getEmail().equals(mail)){
                EmpleadoDataType nuevo = new EmpleadoDataType(c.getEmail(),c.getNombre(),c.getApellido(),c.getPassword(),c.getDocumento(),c.getTelefono(),c.getDireccion(),c.getCiudad(),c.getTipo());
                return nuevo;
            }
        }
        return null;
    }

    public EmpleadoDAO(){
        this.empleadoBD = EmpleadoBD.getInstance();
    }
}
