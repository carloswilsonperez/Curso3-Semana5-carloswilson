package com.carloswilson.curso3_semana5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.carloswilson.curso3_semana5.adapter.MascotaAdaptador;
import com.carloswilson.curso3_semana5.pojo.Mascota;
import com.carloswilson.curso3_semana5.R;
import com.carloswilson.curso3_semana5.db.BaseDatos;

import java.util.ArrayList;

public class MascotasActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_detalle_rv);

        Toolbar toolbar = (Toolbar) findViewById(R.id.miToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        // Instacia el linearLayoutManager que sirve para manejar la forma en que se ve la lista
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Le decimos que el RecyclerView se comporte como un LinearLayoutManager y adquiera todas sus propiedades
        listaMascotas.setLayoutManager(llm);

        // Inicializamos la lista de mascotas
        mascotas = inicializarListaMascotasFav();
        Log.i("MASCOTAS", mascotas.toString());

        // Inicializamos el adaptador
        inicializaAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item_menu) {
        int id = item_menu.getItemId(); // obtengo el item de cada item del menu
        //noinspection SimplifiableIfStatement
        if (id == R.id.accion_salir) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item_menu);
    }

    //****** Inicializa el adaptador *************************
    public void inicializaAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    //********** Cargo las mascotas a mostrar *****************
    public ArrayList<Mascota> inicializarListaMascotasFav(){
        BaseDatos db = new BaseDatos(this);
        db.obtenerMascotasFav();
        return db.obtenerMascotasFav();
        /*
        mascotas.add(new Mascota("Yaman", 5, R.drawable.perro01, R.color.fondo_perro01));
        mascotas.add(new Mascota("Fausto", 4, R.drawable.perro04, R.color.fondo_perro04));
        mascotas.add(new Mascota("Toby", 3, R.drawable.perro02, R.color.fondo_perro02));
        mascotas.add(new Mascota("Peñarol", 3, R.drawable.perro03, R.color.fondo_perro03));
        mascotas.add(new Mascota("Pulgarcito", 2, R.drawable.perro00, R.color.fondo_perro00));
        */
    }
}