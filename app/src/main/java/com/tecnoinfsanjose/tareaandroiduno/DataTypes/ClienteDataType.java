package com.tecnoinfsanjose.tareaandroiduno.DataTypes;


import java.io.Serializable;

public class ClienteDataType implements Serializable{
    private String email;
    private String nombre;
    private String apellido;
    private String password;
    private String documento;
    private String telefono;
    private String direccion;
    private String ciudad;

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPassword() {
        return password;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getTipo() {
        return tipo;
    }

    private String tipo;

    public ClienteDataType(String email, String nombre, String apellido, String password, String documento, String telefono, String direccion, String ciudad, String tipo) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.documento = documento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.tipo = tipo;
    }
}
