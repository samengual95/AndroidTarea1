package com.tecnoinfsanjose.tareaandroiduno.Controladores;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tecnoinfsanjose.tareaandroiduno.Modelos.Cliente;
import com.tecnoinfsanjose.tareaandroiduno.R;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter{
    private ArrayList<Cliente> clientes;
    private Context context;

    public Adaptador(Context context,ArrayList<Cliente> clientes) {
        this.clientes = clientes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int position) {
        return clientes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cliente cliente = (Cliente) getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.item,null);
        TextView tvNombre = convertView.findViewById(R.id.textView9);
        TextView tvApellido = convertView.findViewById(R.id.textView10);
        tvNombre.setText(cliente.getNombre());
        tvApellido.setText(cliente.getApellido());
        return convertView;
    }
}
