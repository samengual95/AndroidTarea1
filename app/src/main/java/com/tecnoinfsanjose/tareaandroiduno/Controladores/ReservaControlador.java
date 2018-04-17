package com.tecnoinfsanjose.tareaandroiduno.Controladores;


import com.tecnoinfsanjose.tareaandroiduno.Controladores.DAOs.ReservaDAO;
import com.tecnoinfsanjose.tareaandroiduno.Modelos.Cliente;
import com.tecnoinfsanjose.tareaandroiduno.Modelos.Reserva;

public class ReservaControlador {
    private Reserva reserva;
    private ReservaDAO reservaDAO;

    public ReservaControlador() {
        this.reserva = new Reserva();
        this.reservaDAO = new ReservaDAO();
    }

    public void altaReserva(String fecha,Cliente c){
        Reserva nueva = new Reserva();
        nueva.setFecha(fecha);
        nueva.setCliente(c);
        nueva.setEmpleado(null);
        reservaDAO.altaReserva(nueva);
    }
}
