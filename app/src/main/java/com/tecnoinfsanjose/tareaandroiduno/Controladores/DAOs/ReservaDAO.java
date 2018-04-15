package com.tecnoinfsanjose.tareaandroiduno.Controladores.DAOs;

import com.tecnoinfsanjose.tareaandroiduno.Controladores.BD.ReservaBD;
import com.tecnoinfsanjose.tareaandroiduno.Modelos.Reserva;

import java.util.Iterator;


public class ReservaDAO {

    private ReservaBD reservaBD;

    public void altaReserva(Reserva r){
        reservaBD.setReserva(r);
    }
    public void bajaReserva(Reserva r){}

    public void modReserva(Reserva r){}

    public Boolean buscarReservaPorFecha(String fecha){
        Iterator iterator = reservaBD.getReservas().iterator();
        while (iterator.hasNext()){
            Reserva nueva = (Reserva) iterator.next();
            if(nueva.getFecha().equals(fecha)){
                return true;
            }
        }
        return false;
    }
    public Boolean buscarReservaPorCliente(String mail){
        Iterator iterator = reservaBD.getReservas().iterator();
        while (iterator.hasNext()){
            Reserva nueva = (Reserva) iterator.next();
            if(nueva.getCliente().getEmail().equals(mail))
                return true;
        }
        return false;
    }
    public ReservaDAO(){
        reservaBD = ReservaBD.getInstance();
    }
}