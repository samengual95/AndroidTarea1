package com.tecnoinfsanjose.tareaandroiduno.Vistas.Fragments;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tecnoinfsanjose.tareaandroiduno.Controladores.ClienteControlador;
import com.tecnoinfsanjose.tareaandroiduno.Controladores.ReservaControlador;
import com.tecnoinfsanjose.tareaandroiduno.DataTypes.ClienteDataType;
import com.tecnoinfsanjose.tareaandroiduno.R;
import com.tecnoinfsanjose.tareaandroiduno.Vistas.Activities.IActivityHome;

/**
 * A simple {@link Fragment} subclass.
 */

public class DialogoConfirmarCliente extends DialogFragment {


    public DialogoConfirmarCliente() {
        // Required empty public constructor
    }
    IActivityHome iActivityHome;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.mensaje_cliente)
                .setTitle(R.string.titulo)
                .setNegativeButton(R.string.boton_no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setPositiveButton(R.string.boton_si, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ClienteDataType c = (ClienteDataType) getActivity().getIntent().getExtras().getSerializable("cliente");
                        String fecha = (String) getActivity().getIntent().getExtras().get("fecha");
                        ReservaControlador n = new ReservaControlador();
                        ClienteControlador cli = new ClienteControlador();
                        n.altaReserva(fecha,cli.retornoClienteSesion(c.getEmail()));
                        iActivityHome.cargarHomeCliente();
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iActivityHome = (IActivityHome) getActivity();
    }
}
