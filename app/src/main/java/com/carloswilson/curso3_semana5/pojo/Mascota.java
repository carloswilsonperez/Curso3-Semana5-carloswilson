package com.carloswilson.curso3_semana5.pojo;

import java.security.AccessController;
import java.security.Provider;

/**
 * Created by Carlos Wilson on 03/31/2018
 */

public class Mascota {

    private String nombre;
    private int numLinkes;
    private int foto;
    private int colorFondo;
    private int Id;

    //Contructor
    public Mascota (String nombre, int numLinkes, int foto, int colorFondo){
        this.nombre = nombre;
        this.numLinkes = numLinkes;
        this.foto = foto;
        this.colorFondo = colorFondo;
    }

    public Mascota() {
        //Constructor vacio requerido para el llenado de datos desde la base de datos
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumLinkes() {
        return numLinkes;
    }

    public void setNumLinkes(int numLinkes) {
        this.numLinkes = numLinkes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(int colorFondo) {
        this.colorFondo = colorFondo;
    }

    public void setId(int id) {
        Id = id;
    }
    public int getId() {
        return Id;
    }

    public static final class JSSEProvider extends Provider {

        public JSSEProvider() {
            super("HarmonyJSSE", 1.0, "Harmony JSSE Provider");
            AccessController.doPrivileged(new java.security.PrivilegedAction<Void>() {
                public Void run() {
                    put("SSLContext.TLS",
                            "org.apache.harmony.xnet.provider.jsse.SSLContextImpl");
                    put("Alg.Alias.SSLContext.TLSv1", "TLS");
                    put("KeyManagerFactory.X509",
                            "org.apache.harmony.xnet.provider.jsse.KeyManagerFactoryImpl");
                    put("TrustManagerFactory.X509",
                            "org.apache.harmony.xnet.provider.jsse.TrustManagerFactoryImpl");
                    return null;
                }
            });
        }
    }
}
