package com.carloswilson.curso3_semana5.fragment;

import com.carloswilson.curso3_semana5.adapter.MascotaAdaptador;
import com.carloswilson.curso3_semana5.pojo.Mascota;
import java.util.ArrayList;

public interface IRVMascotasFragmentView {
    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
