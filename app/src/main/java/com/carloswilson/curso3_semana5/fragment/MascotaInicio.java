package com.carloswilson.curso3_semana5.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.carloswilson.curso3_semana5.pojo.Mascota;
import com.carloswilson.curso3_semana5.R;
import com.carloswilson.curso3_semana5.adapter.MascotaAdaptador;
import com.carloswilson.curso3_semana5.presentador.IRVMascotasFragmentPresenter;
import com.carloswilson.curso3_semana5.presentador.RVMascotasFragmentPresenter;
import java.util.ArrayList;

/**
 * Created by Carlos Wilson on 03/31/2018
 */

public class MascotaInicio extends Fragment implements IRVMascotasFragmentView {
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRVMascotasFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View miView = inflater.inflate(R.layout.fragment_mascota_inicio_rv, container, false);
        listaMascotas = (RecyclerView) miView.findViewById(R.id.rvMascotas);
        presenter = new RVMascotasFragmentPresenter(this, getContext());

        // Inflamos el layout para este fragment
        return miView;
    }

    //Aqui esta el DataSet -- se cambio por la base de datos

   /* public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota (...));
        mascotas.add(new Mascota (...));
    }*/

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}