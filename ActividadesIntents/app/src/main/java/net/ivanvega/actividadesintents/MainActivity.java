package net.ivanvega.actividadesintents;

import android.content.Intent;
import android.content.res.Resources;
import android.os.PersistableBundle;
import android.support.annotation.ColorInt;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button miBoton ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miBoton = (Button)findViewById(R.id.btnActivity);
        miBoton.setText("Mi actividad");
        miBoton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light) );


        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(),"Click en el boton", Toast.LENGTH_SHORT)
                        .show();


                Intent miIntent = new Intent(getApplicationContext(), OtraActividad.class);
                miIntent.putExtra("miparam", "Hola Mundo!");
                miIntent.putExtra("otroparam", 2);

                Bundle miamigobungle = new Bundle();

                miamigobungle.putString("param", "Valor de parametro de bundle");
                miamigobungle.putShort("param2", (short) 100);


                //startActivity(miIntent);
                    startActivityForResult(miIntent, 1000);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode==1000 && resultCode==RESULT_OK){
            if (resultCode== RESULT_OK){
                Toast.makeText(getApplication(),
                        data.getStringExtra("parametro"),
                        Toast.LENGTH_LONG).show();
            }
        }



        super.onActivityResult(requestCode, resultCode, data);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CICLO", "paso por el metodo onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CICLO", "paso por el metodo onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CICLO", "paso por el metodo onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("CICLO", "la actividad pueque este por destruirse");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("CICLO", "paso por el metodo onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("CICLO", "Tdo esta destruido");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}

