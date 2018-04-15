package com.tecnoinfsanjose.tareaandroiduno.Controladores.BD;

import com.tecnoinfsanjose.tareaandroiduno.Modelos.Cliente;

import java.util.ArrayList;


public class ClienteBD {

    private ArrayList<Cliente> clientes;
    private static ClienteBD clienteBD=null;

    public static ClienteBD getInstance(){
        if (clienteBD==null){
            clienteBD = new ClienteBD();
        }
        return clienteBD;
    }

    public void setCliente(Cliente c){
        clientes.add(c);
    }

    private ClienteBD(){
        clientes=new ArrayList<Cliente>();
    }

    public ArrayList<Cliente> getClientes(){
        return this.clientes;
    }

}
