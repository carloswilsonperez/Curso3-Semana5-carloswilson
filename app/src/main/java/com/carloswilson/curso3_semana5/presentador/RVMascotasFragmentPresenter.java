package com.carloswilson.curso3_semana5.presentador;

import android.content.Context;

import com.carloswilson.curso3_semana5.db.ConstructorMascotas;
import com.carloswilson.curso3_semana5.pojo.Mascota;
import com.carloswilson.curso3_semana5.fragment.IRVMascotasFragmentView;

import java.util.ArrayList;

/**
 * Created by Carlos Wilson on 03/31/2018
 */

public class RVMascotasFragmentPresenter implements IRVMascotasFragmentPresenter {

    private IRVMascotasFragmentView iRVMascotasFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RVMascotasFragmentPresenter(IRVMascotasFragmentView iRVMascotasFragmentView, Context context) {
        this.iRVMascotasFragmentView = iRVMascotasFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRVMascotasFragmentView.inicializarAdaptadorRV(iRVMascotasFragmentView.crearAdaptador(mascotas));
        iRVMascotasFragmentView.generarLinearLayoutVertical();
    }
}