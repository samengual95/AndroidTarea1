package com.tecnoinfsanjose.tareaandroiduno.Vistas.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tecnoinfsanjose.tareaandroiduno.Controladores.ClienteControlador;
import com.tecnoinfsanjose.tareaandroiduno.Controladores.DAOs.ClienteDAO;
import com.tecnoinfsanjose.tareaandroiduno.Controladores.EmpleadoControlador;
import com.tecnoinfsanjose.tareaandroiduno.Vistas.Activities.IActivityInicio;
import com.tecnoinfsanjose.tareaandroiduno.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Registrarse.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Registrarse#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Registrarse extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private ImageButton boton_atras;
    private ImageButton boton_confirmar;
    private TextView texto_correo,texto_nombre,texto_apellido,texto_contra,texto_contra2,texto_doc,texto_telefono,texto_direccion,texto_ciudad;
    private Spinner tipo;

    IActivityInicio iActivityInicio;

    private OnFragmentInteractionListener mListener;

    public String getCorreo(){
        texto_correo = getView().findViewById(R.id.editText3);
        return texto_correo.getText().toString();
    }
    public String getNombre(){
        texto_nombre = getView().findViewById(R.id.editText4);
        return texto_nombre.getText().toString();
    }
    public String getApellido(){
        texto_apellido = getView().findViewById(R.id.editText5);
        return texto_apellido.getText().toString();
    }
    public String getPassword(){
        texto_contra = getView().findViewById(R.id.editText6);
        return texto_contra.getText().toString();
    }
    public String getPassword2(){
        texto_contra2 = getView().findViewById(R.id.editText7);
        return texto_contra2.getText().toString();
    }
    public String getDocumento(){
        texto_doc = getView().findViewById(R.id.editText8);
        return texto_doc.getText().toString();
    }
    public String getTelefono(){
        texto_telefono = getView().findViewById(R.id.editText9);
        return texto_telefono.getText().toString();
    }
    public String getDireccion(){
        texto_direccion = getView().findViewById(R.id.editText10);
        return texto_direccion.getText().toString();
    }
    public String getCiudad(){
        texto_ciudad = getView().findViewById(R.id.editText11);
        return texto_ciudad.getText().toString();
    }
    public String getTipo(){
        tipo = getView().findViewById(R.id.spinner);
        return tipo.getSelectedItem().toString();
    }


    public Registrarse() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Registrarse.
     */
    // TODO: Rename and change types and number of parameters
    public static Registrarse newInstance(String param1, String param2) {
        Registrarse fragment = new Registrarse();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registrarse, container, false);
        boton_atras = view.findViewById(R.id.imageButton3);
        boton_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iActivityInicio.abrirLogin();
            }
        });
        boton_confirmar = view.findViewById(R.id.imageButton);
        boton_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(getTipo().equals("Cliente")) {
                        ClienteControlador nuevo = new ClienteControlador();
                        nuevo.altaCliente(getCorreo(), getNombre(), getApellido(), getPassword(), getPassword2(), getDocumento(), getTelefono()
                                , getDireccion(), getCiudad(), getTipo());

                        AlertDialog alerta = new AlertDialog.Builder(getActivity()).create();
                        alerta.setTitle("Aviso");
                        alerta.setMessage("Registrado exitosamente!");
                        alerta.setCancelable(true);
                        alerta.show();
                        //Toast.makeText(getActivity(),"Usuario registrado!",Toast.LENGTH_SHORT);
                        iActivityInicio.moverseActivityHomeCliente(nuevo.datosCliente(getCorreo()));
                    }
                    else{
                        EmpleadoControlador nuevo1 = new EmpleadoControlador();
                        nuevo1.altaEmpleado(getCorreo(), getNombre(), getApellido(), getPassword(), getPassword2(), getDocumento(), getTelefono()
                                , getDireccion(), getCiudad(), getTipo());
                        AlertDialog alerta = new AlertDialog.Builder(getActivity()).create();
                        alerta.setTitle("Aviso");
                        alerta.setMessage("Registrado exitosamente!");
                        alerta.setCancelable(true);
                        alerta.show();
                        iActivityInicio.moverseActivityHomeEmpleado(nuevo1.datosEmpleado(getCorreo()));
                    }
                }catch (Exception e){
                    AlertDialog alerta= new AlertDialog.Builder(getActivity()).create();
                    alerta.setTitle("Error");
                    alerta.setMessage(e.getMessage());
                    alerta.setCancelable(true);
                    alerta.show();
                    //Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        iActivityInicio = (IActivityInicio) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
