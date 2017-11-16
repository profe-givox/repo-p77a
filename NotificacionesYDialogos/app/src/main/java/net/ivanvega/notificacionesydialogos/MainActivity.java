package net.ivanvega.notificacionesydialogos;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.SupportActionModeWrapper;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String colores[] =
            new String[]
                    {"verde", "blanco", "rojo"};

    String generos_musicales[] =
            new String[]
                    {"rock", "clasica", "jazz", "pop", };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnInfo_click(View v){

        AlertDialog dialog =
                new AlertDialog.Builder(this)
                        .setTitle("Cuadro de dialogo")
                        .setIcon(android.R.drawable.ic_btn_speak_now)
                        .setMessage("Hola Mubndo desde Android")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Toast.makeText(MainActivity.this,
                                        "Presiono OK", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,
                                        "Presiono OK", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .create();

        dialog.show();


    }

    public void  btnList_click(View v){
        AlertDialog dialog =
                new AlertDialog.Builder(this)
                        .setTitle("Cuadro de dialogo")
                        .setIcon(R.mipmap.ic_launcher)
                        .setItems(colores, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,
                                        colores[which], Toast.LENGTH_SHORT)
                                        .show();
                                dialog.dismiss();
                            }
                        })
                        .create();

        dialog.show();
    }


    public void  btnCheckList_click(View v){
        AlertDialog dialog =
                new AlertDialog.Builder(this)
                        .setTitle("Cuadro de dialogo")
                        .setIcon(R.mipmap.ic_launcher)

                        .setMultiChoiceItems(generos_musicales,
                                new boolean[]{true, false, true, false}
                                , new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        Toast.makeText(MainActivity.this,
                                                generos_musicales[which] + (isChecked? " Verificado": "No Verificado"),
                                                Toast.LENGTH_SHORT)
                                                .show();
                                    }
                                })
                        .create();

        dialog.show();
    }


    public void btnTimePicker_click(View v){
        DialogFragment timePickerDialogFragment =
                new MiTimePickerFragment();

        timePickerDialogFragment.show(getSupportFragmentManager(), "timepicker");
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public  void btnDatePicker_click(View v){

        // Use the current date as the default date in the picker
         Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickDialog =
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            Log.d("DATEPICKER", "Fecha seleccionada: "
                                    + String.valueOf(dayOfMonth) + "/" +
                                    String.valueOf(month) + "/" + String.valueOf(year));
                        }

                }, year,month,day);

        datePickDialog.show();


    }
}
