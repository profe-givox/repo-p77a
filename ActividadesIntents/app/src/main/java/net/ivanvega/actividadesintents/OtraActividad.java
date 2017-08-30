package net.ivanvega.actividadesintents;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by alcohonsilver on 25/08/17.
 */

public class OtraActividad extends AppCompatActivity {
    Button btn ;
    EditText txt;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_otraactividad);

         Intent i = getIntent();

        this.setTitle(i.getStringExtra("miparam"));
        Toast.makeText(this,
                String.valueOf( i.getIntExtra("otroparam",0)),
                Toast.LENGTH_LONG ).show();

        btn = (Button)findViewById(R.id.btnRegresar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("parametro", txt.getText().toString());
                setResult(RESULT_OK, i);


                finish();
            }
        });

        txt = (EditText)findViewById(R.id.txtParam);

    }



}

