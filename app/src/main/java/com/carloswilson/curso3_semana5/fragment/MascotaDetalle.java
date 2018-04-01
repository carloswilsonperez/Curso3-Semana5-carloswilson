package com.carloswilson.curso3_semana5.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.carloswilson.curso3_semana5.adapter.PerfilAdaptador;
import com.carloswilson.curso3_semana5.pojo.Mascota;
import com.carloswilson.curso3_semana5.R;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaDetalle extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaPerfiles;
    public PerfilAdaptador adaptador;

    public MascotaDetalle() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_mascota_detalle, container, false);
        // Inflate the layout for this fragment
        //   return inflater.inflate(R.layout.fragment_mascota_detalle, container, false);

        listaPerfiles = (RecyclerView) v.findViewById(R.id.rvPerfil);

        // Instacia el GridLayoutManager que sirve para manejar la forma en que se ve la lista
        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);

        //Le decimos que el RecyclerView se comporte como un LinearLayoutManager y adquiera todas sus propiedades
        listaPerfiles.setLayoutManager(glm);
        inicializarListaMascotas(); // Inicializamos la lista de mascotas
        inicializaAdaptador();    // Inicializamos el adaptador

        return v;
    }

    // Inicializa el adaptador
    public void inicializaAdaptador(){
        adaptador = new PerfilAdaptador(mascotas, getActivity());
        listaPerfiles.setAdapter(adaptador);
    }

    // Cargo las mascotas a mostrar
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Yaman", 2, R.drawable.perro01, R.color.fondo_perro00));
        mascotas.add(new Mascota("Yaman", 5, R.drawable.perro01, R.color.fondo_perro01));
        mascotas.add(new Mascota("Yaman", 3, R.drawable.perro01, R.color.fondo_perro02));
        mascotas.add(new Mascota("Yaman", 3, R.drawable.perro01, R.color.fondo_perro01));
        mascotas.add(new Mascota("Yaman", 4, R.drawable.perro01, R.color.fondo_perro01));
        mascotas.add(new Mascota("Yaman", 2, R.drawable.perro01, R.color.fondo_perro01));
        mascotas.add(new Mascota("Yaman", 2, R.drawable.perro01, R.color.fondo_perro01));
        mascotas.add(new Mascota("Yaman", 2, R.drawable.perro01, R.color.fondo_perro01));
        mascotas.add(new Mascota("Yaman", 5, R.drawable.perro01, R.color.fondo_perro01));
    }
}
