package com.tecnoinfsanjose.tareaandroiduno.Controladores;

import com.tecnoinfsanjose.tareaandroiduno.Controladores.DAOs.ClienteDAO;
import com.tecnoinfsanjose.tareaandroiduno.DataTypes.ClienteDataType;
import com.tecnoinfsanjose.tareaandroiduno.Modelos.Cliente;


public class ClienteControlador {

    private ClienteDAO clienteDAO;
    private Cliente cliente;

    public ClienteControlador() {
        this.clienteDAO = new ClienteDAO();
        this.cliente = new Cliente();
    }

    public void altaCliente(String correo,String nombre, String ape, String contrasenia, String conf_contra, String documento, String telefono, String direccion, String ciudad, String tipo) throws Exception {
            if(!nombre.isEmpty() && !correo.isEmpty() && !tipo.isEmpty() && !contrasenia.isEmpty() && !conf_contra.isEmpty()){
                if (contrasenia.equals(conf_contra)){
                    //Crear instancia y pasarla a ClienteDAO
                    cliente.setEmail(correo);
                    cliente.setNombre(nombre);
                    cliente.setApellido(ape);
                    cliente.setPassword(contrasenia);
                    cliente.setDocumento(documento);
                    cliente.setTelefono(telefono);
                    cliente.setDireccion(direccion);
                    cliente.setCiudad(ciudad);
                    cliente.setTipo(tipo);
                    clienteDAO.altaCliente(cliente);
                }
                else throw new Exception("Las contraseñas no coinciden.");
            }
            else throw new Exception("Debe completar los campos obligatorios.");
    }


    public ClienteDataType inicioSesion(String mail, String pass) throws Exception{
            if(mail != null && pass != null){
                if(clienteDAO.buscarCliente(mail)){
                    ClienteDataType cli = clienteDAO.datosCliente(mail);
                    if(cli.getPassword().equals(pass))
                        return clienteDAO.datosCliente(mail);
                    else throw new Exception("Contraseña incorrecta.");
                }
                else throw new Exception("El e-mail ingresado no esta registrado.");
            }
            else throw new Exception("Complete ambos campos.");

    }
    public ClienteDataType datosCliente(String mail){
        return clienteDAO.datosCliente(mail);
    }


    public Boolean buscarCliente(String mail){
        return clienteDAO.buscarCliente(mail);
    }
}

