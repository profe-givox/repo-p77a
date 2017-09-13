package net.ivanvega.miaudiolibros;

import java.util.Vector;

/**
 * Created by alcohonsilver on 12/09/17.
 */

public class InfoGlobal {
    private Vector<Libro> vectorLibros;
    private AdaptadorLibros adaptador;

    private  static InfoGlobal INSTANCIA = new InfoGlobal();

    private InfoGlobal(){}

    public static InfoGlobal getInstance (){
        return INSTANCIA;
    }

}
