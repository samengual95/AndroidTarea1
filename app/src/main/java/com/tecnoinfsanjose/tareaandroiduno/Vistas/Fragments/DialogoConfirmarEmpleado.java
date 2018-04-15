package com.tecnoinfsanjose.tareaandroiduno.Vistas.Fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.tecnoinfsanjose.tareaandroiduno.R;



public class DialogoConfirmarEmpleado extends android.support.v4.app.DialogFragment {


    public DialogoConfirmarEmpleado() {
        // Required empty public constructor
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.mensaje_empleado)
                .setTitle(R.string.titulo1)
                .setNegativeButton(R.string.boton_no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                })
                .setPositiveButton(R.string.boton_si, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Volver a home cliente

                    }
                });

        return builder.create();
    }
}
