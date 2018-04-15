package com.tecnoinfsanjose.tareaandroiduno.Controladores.BD;


import com.tecnoinfsanjose.tareaandroiduno.Modelos.Reserva;

import java.util.ArrayList;

public class ReservaBD {
    private ArrayList<Reserva> reservas;
    private static ReservaBD reservaBD=null;

    public static ReservaBD getInstance(){
        if (reservaBD==null){
            reservaBD = new ReservaBD();
        }
        return reservaBD;
    }
    public void setReserva(Reserva r){
        reservas.add(r);
    }

    public ArrayList<Reserva> getReservas(){
        return this.reservas;
    }

    private ReservaBD(){
        this.reservas = new ArrayList<>();
    }

}
