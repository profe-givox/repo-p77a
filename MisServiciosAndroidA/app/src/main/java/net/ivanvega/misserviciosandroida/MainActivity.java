package net.ivanvega.misserviciosandroida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnI_click(View v){
        Toast.makeText(this,"INTERACTUANDO HILO PRINCIPAL",
                Toast.LENGTH_SHORT).show();
    }

    public void btnIS_click(View v){
        Toast.makeText(this,"arrancando intent servicio",
                Toast.LENGTH_SHORT).show();

        Intent is = new Intent(this,MiIntentService.class);

        startService(is);
    }

    public void btnS_click(View v){
        Toast.makeText(this,"arrancando intent servicio",
                Toast.LENGTH_SHORT).show();

        Intent is = new Intent(this,HelloService.class);

        startService(is);
    }

}
