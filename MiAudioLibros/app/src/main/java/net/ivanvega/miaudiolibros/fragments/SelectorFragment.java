package net.ivanvega.miaudiolibros.fragments;


import android.app.Activity;
import android.content.Context;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.ivanvega.miaudiolibros.AdaptadorLibros;
import net.ivanvega.miaudiolibros.Aplicacion;
import net.ivanvega.miaudiolibros.InfoGlobal;
import net.ivanvega.miaudiolibros.Libro;
import net.ivanvega.miaudiolibros.R;

import java.util.Vector;

/**
 * Created by alcohonsilver on 18/09/17.
 */

public class SelectorFragment extends Fragment {
    private Activity actividad;
    private RecyclerView recyclerView;
    private AdaptadorLibros adaptador;
    private Vector<Libro> vectorLibros;

    @Override
    public void onAttach(Context contexto) {
        super.onAttach(contexto);
        if (contexto instanceof Activity) {
            this.actividad = (Activity) contexto;
            InfoGlobal inf = InfoGlobal.getInstance();
            inf.inicializa(contexto);
            adaptador = inf.getAdaptador();
            vectorLibros = inf.getVectorLibros();
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflador, ViewGroup contenedor, Bundle savedInstanceState) {
        View vista = inflador.inflate
                (R.layout.fragment_selector, contenedor, false);
        recyclerView = (RecyclerView) vista.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(actividad,2));
        recyclerView.setAdapter(adaptador);
        adaptador.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(actividad, "Seleccionado el elemento: "
                        + recyclerView.getChildAdapterPosition(v),
                        Toast.LENGTH_SHORT)
                        .show();

            } }
        );
        return vista;
    }


}
