package net.ivanvega.manejodefragmentos;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnHardcode_click (View v){
        startActivity(
                new Intent(this, ActividadConFragmentHardcoded.class)
        );
    }

    public void btnDinamico_click(View v){

       android.app.FragmentManager fm =  getFragmentManager();
         android.app.FragmentTransaction ft =  fm.beginTransaction();

        FragemntoDos frag = new FragemntoDos();

        ft.add(R.id.contenedor_fragment,  frag);

        ft.commit();

    }

}
