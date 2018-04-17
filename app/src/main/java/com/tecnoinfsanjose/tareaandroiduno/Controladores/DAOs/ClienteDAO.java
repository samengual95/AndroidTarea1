package com.tecnoinfsanjose.tareaandroiduno.Controladores.DAOs;


import com.tecnoinfsanjose.tareaandroiduno.Controladores.BD.ClienteBD;
import com.tecnoinfsanjose.tareaandroiduno.DataTypes.ClienteDataType;
import com.tecnoinfsanjose.tareaandroiduno.Modelos.Cliente;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class ClienteDAO {

    private ClienteBD clienteBD;

    public void altaCliente(Cliente c){
        clienteBD.setCliente(c);
    }

    public void modCliente(Cliente c){
        //Modificar cliente c
    }
    public void bajaCliente(Cliente c){
        //Eliminar Cliente c
    }
    public Boolean buscarCliente(String mail){
        Iterator iterator = clienteBD.getClientes().iterator();
        while(iterator.hasNext()){
            Cliente c = (Cliente) iterator.next();
            if(c.getEmail().equals(mail))
                return true;
        }
        return false;
    }
    public ClienteDataType datosCliente(String mail){
        Iterator iterator = clienteBD.getClientes().iterator();
        while(iterator.hasNext()){
            Cliente c = (Cliente) iterator.next();
            if(c.getEmail().equals(mail)){
                ClienteDataType nuevo = new ClienteDataType(c.getEmail(),c.getNombre(),c.getApellido(),c.getPassword(),c.getDocumento(),c.getTelefono(),c.getDireccion(),c.getCiudad(),c.getTipo());
                return nuevo;
            }
        }
        return null;
    }
    public Cliente retornoCliente(String mail){
        Iterator iterator = clienteBD.getClientes().iterator();
        while(iterator.hasNext()){
            Cliente c = (Cliente) iterator.next();
            if(c.getEmail().equals(mail)){
                return c;
            }
        }
        return null;
    }
    public ArrayList<Cliente> darClientes(){
        return clienteBD.getClientes();
    }

    public ClienteDAO() {
        this.clienteBD = ClienteBD.getInstance();
    }
}
