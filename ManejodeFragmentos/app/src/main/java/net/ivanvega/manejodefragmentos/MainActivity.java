package net.ivanvega.manejodefragmentos;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        android.app.FragmentManager fm = getFragmentManager();

        Fragment fra = fm.findFragmentById(R.id.contenedor_fragment);


        if(fra==null){
            Toast.makeText(this, "El fragmento no esta cargado", Toast.LENGTH_LONG).show();
        }

    }

    public void btnHardcode_click (View v){
        startActivity(
                new Intent(this, ActividadConFragmentHardcoded.class)
        );
    }

    public void btnDinamico_click(View v){

       android.app.FragmentManager fm =  getFragmentManager();



        if (fm.findFragmentById(R.id.contenedor_fragment)==null) {


            android.app.FragmentTransaction ft = fm.beginTransaction();

            FragemntoDos frag = new FragemntoDos();

            ft.add(R.id.contenedor_fragment, frag);

            ft.commit();
        }else{
            Toast.makeText(this, "El fragmento ya esta cargado esta cargado", Toast.LENGTH_LONG).show();
        }

    }

}
