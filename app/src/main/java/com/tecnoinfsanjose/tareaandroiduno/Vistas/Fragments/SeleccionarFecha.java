package com.tecnoinfsanjose.tareaandroiduno.Vistas.Fragments;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeleccionarFecha extends android.support.v4.app.DialogFragment
        implements DatePickerDialog.OnDateSetListener{

    int dia,mes,anio;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        anio = c.get(Calendar.YEAR);
        mes = c.get(Calendar.MONTH);
        dia = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, dia, mes, anio);
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        TextView texto_fecha = view.findViewById(R.id.textView4);
        dia=day;
        mes=month+1;
        anio=year;
        texto_fecha.setText(dia+"/"+mes+"/"+anio);

    }

    public SeleccionarFecha() {
        // Required empty public constructor
    }

}
