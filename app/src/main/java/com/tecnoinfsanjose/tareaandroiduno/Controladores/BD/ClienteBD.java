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
        Cliente c = new Cliente();
        c.setEmail("Santi");
        c.setNombre("Santiago");
        c.setApellido("Amengual");
        c.setPassword("hola");
        c.setDocumento("47174359");
        c.setDireccion("avebrasil431");
        c.setTelefono("099148655");
        c.setCiudad("Sanjo");
        c.setTipo("Cliente");
        Cliente c1 = new Cliente();
        c1.setEmail("Huguito");
        c1.setNombre("Hugo");
        c1.setApellido("Saavedra");
        c1.setPassword("hola");
        c1.setDocumento("47174359");
        c1.setDireccion("avebrasil431");
        c1.setTelefono("099148655");
        c1.setCiudad("Sanjo");
        c1.setTipo("Cliente");
        Cliente c2 = new Cliente();
        c2.setEmail("Carlitos");
        c2.setNombre("Carlos");
        c2.setApellido("Rodriguez");
        c2.setPassword("hola");
        c2.setDocumento("47174359");
        c2.setDireccion("avebrasil431");
        c2.setTelefono("099148655");
        c2.setCiudad("Sanjo");
        c2.setTipo("Cliente");
        clientes.add(c);
        clientes.add(c1);
        clientes.add(c2);
    }

    public ArrayList<Cliente> getClientes(){
        return this.clientes;
    }

}
