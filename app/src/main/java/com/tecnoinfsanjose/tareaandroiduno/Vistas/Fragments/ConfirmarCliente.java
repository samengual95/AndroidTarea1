package com.tecnoinfsanjose.tareaandroiduno.Vistas.Fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.tecnoinfsanjose.tareaandroiduno.Vistas.Activities.IActivityHome;
import com.tecnoinfsanjose.tareaandroiduno.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConfirmarCliente.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConfirmarCliente#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfirmarCliente extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageView imagen;
    private Button boton_confirmar;
    private ImageButton atras;
    private OnFragmentInteractionListener mListener;

    IActivityHome iActivityHome;

    public ConfirmarCliente() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConfirmarCliente.
     */
    // TODO: Rename and change types and number of parameters
    public static ConfirmarCliente newInstance(String param1, String param2) {
        ConfirmarCliente fragment = new ConfirmarCliente();
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
        View view = inflater.inflate(R.layout.fragment_confirmar_cliente, container, false);
        imagen = view.findViewById(R.id.imageView3);
        Drawable originalDrawable = getResources().getDrawable(R.mipmap.ic_launcher_round);
        Bitmap originalBitMap = ((BitmapDrawable) originalDrawable).getBitmap();
        RoundedBitmapDrawable roundedDrawable = RoundedBitmapDrawableFactory.create(getResources(), originalBitMap);
        imagen.setImageDrawable(roundedDrawable);
        atras = view.findViewById(R.id.imageButton2);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iActivityHome.cargarHomeCliente();
    }
});
        boton_confirmar = view.findViewById(R.id.button);
        boton_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoConfirmar nuevo = new DialogoConfirmar();
                nuevo.show(getFragmentManager(),"dialogo");
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
