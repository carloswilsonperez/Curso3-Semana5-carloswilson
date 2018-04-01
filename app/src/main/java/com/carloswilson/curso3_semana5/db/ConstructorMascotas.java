package com.carloswilson.curso3_semana5.db;

import android.content.Context;
import com.carloswilson.curso3_semana5.pojo.Mascota;
import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        db.obtenerTodasLasMascotas();
        return db.obtenerTodasLasMascotas();
    }


    public void darLikeMascota (Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        /*ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_NUM_LIKES, LIKE);*/
        db.insertarLikeMascota(mascota);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);

        return db.obtenerLikesMascota(mascota);
    }
}
