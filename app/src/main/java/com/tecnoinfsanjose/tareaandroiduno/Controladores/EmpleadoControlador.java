package com.tecnoinfsanjose.tareaandroiduno.Controladores;


import com.tecnoinfsanjose.tareaandroiduno.Controladores.DAOs.EmpleadoDAO;
import com.tecnoinfsanjose.tareaandroiduno.DataTypes.EmpleadoDataType;
import com.tecnoinfsanjose.tareaandroiduno.Modelos.Empleado;

public class EmpleadoControlador {

    private EmpleadoDAO empleadoDAO;
    private Empleado empleado;

    public EmpleadoControlador(){
        empleado = new Empleado();
        empleadoDAO = new EmpleadoDAO();
    }

    public void altaEmpleado(String correo,String nombre, String ape, String contrasenia, String conf_contra, String documento, String telefono, String direccion, String ciudad, String tipo) throws Exception {
        if(!correo.isEmpty() && !nombre.isEmpty() && !contrasenia.isEmpty() && !conf_contra.isEmpty() && !tipo.isEmpty()){
            if (conf_contra.equals(conf_contra)){
                empleado.setEmail(correo);
                empleado.setNombre(nombre);
                empleado.setApellido(ape);
                empleado.setPassword(contrasenia);
                empleado.setDocumento(documento);
                empleado.setTelefono(telefono);
                empleado.setDireccion(direccion);
                empleado.setCiudad(ciudad);
                empleado.setTipo(tipo);
                empleadoDAO.altaEmpleado(empleado);
            }
            else throw new Exception("Las contraseñas no coinciden.");
        }
        else throw new Exception("Complete campos obligatorios.");
    }
    public EmpleadoDataType inicioSesion(String mail,String pass)throws Exception{
        if (!mail.isEmpty() && !pass.isEmpty()){
            if (empleadoDAO.buscarEmpleado(mail)){
                EmpleadoDataType nuevo = empleadoDAO.datosEmpleadp(mail);
                if (nuevo.getPassword().equals(pass))
                    return empleadoDAO.datosEmpleadp(mail);
                else throw new Exception("Contraseña incorrecta.");
            }
            else throw new Exception("El e-mail ingresado no está registrado.");
        }
        else throw new Exception("Complete ambos campos.");
    }
    public EmpleadoDataType datosEmpleado(String mail){
        return empleadoDAO.datosEmpleadp(mail);
    }
    public Boolean buscarEmpleado(String mail){
        return empleadoDAO.buscarEmpleado(mail);
    }
}
