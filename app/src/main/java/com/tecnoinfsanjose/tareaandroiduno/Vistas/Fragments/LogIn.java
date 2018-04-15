package com.tecnoinfsanjose.tareaandroiduno.Vistas.Fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.tecnoinfsanjose.tareaandroiduno.Controladores.ClienteControlador;
import com.tecnoinfsanjose.tareaandroiduno.Controladores.EmpleadoControlador;
import com.tecnoinfsanjose.tareaandroiduno.Vistas.Activities.IActivityInicio;
import com.tecnoinfsanjose.tareaandroiduno.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LogIn.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LogIn#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LogIn extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;

    private TextView texto_registrarse;
    private CardView entrar;
    private EditText texto_mail,texto_password;

    IActivityInicio iActivityInicio;

    public String getMail(){
        texto_mail = getView().findViewById(R.id.editText);
        return texto_mail.getText().toString();
    }
    public String getPassword(){
        texto_password = getView().findViewById(R.id.editText2);
        return texto_password.getText().toString();
    }

    public LogIn() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LogIn.
     */
    // TODO: Rename and change types and number of parameters
    public static LogIn newInstance(String param1, String param2) {
        LogIn fragment = new LogIn();
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
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);
        texto_registrarse = view.findViewById(R.id.textView2);
        texto_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iActivityInicio.cambiarLoginARegistrarse();
            }
        });
        entrar = view.findViewById(R.id.cardView);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    ClienteControlador clienteControlador = new ClienteControlador();
                    EmpleadoControlador empleadoControlador = new EmpleadoControlador();
                    if(clienteControlador.buscarCliente(getMail())){
                        clienteControlador.inicioSesion(getMail(), getPassword());
                        iActivityInicio.moverseActivityHomeCliente(clienteControlador.datosCliente(getMail()));
                    }
                    else{
                        if(empleadoControlador.buscarEmpleado(getMail())){
                            empleadoControlador.inicioSesion(getMail(),getPassword());
                            iActivityInicio.moverseActivityHomeEmpleado(empleadoControlador.datosEmpleado(getMail()));
                        }
                        else throw new Exception("El e-mail ingresado no esta registrado.");
                    }
                }catch (Exception e){
                    android.support.v7.app.AlertDialog alerta= new android.support.v7.app.AlertDialog.Builder(getActivity()).create();
                    alerta.setTitle("Error");
                    alerta.setMessage(e.getMessage());
                    alerta.setCancelable(true);
                    alerta.show();
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
