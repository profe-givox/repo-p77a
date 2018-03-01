package net.ivanvega.missensoresenandroidperrona;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mLight;
    TextView txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        List<Sensor> deviceSensors
                = mSensorManager.getSensorList(Sensor.TYPE_ALL);


        txt = findViewById(R.id.sensor_data);

        for (Sensor sensor : deviceSensors){

            String info ;
            info = sensor.getName() + "\n";
            info += sensor.getPower() + "\n";
            info += sensor.getVendor() + "\n";
            info += sensor.getMaximumRange();

            Toast.makeText(this, info,Toast.LENGTH_SHORT).show();
            Log.i("MISENSORITO", info);


        }

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){
            // Success! There's a magnetometer.
            Toast.makeText(this,
                    "Éxito en la vida, existe el sensor de campo magnético",Toast.LENGTH_SHORT).show();
            Log.i("MISENSORITO", "Éxito en la vida, existe el sensor de campo magnético");
        }
        else {
            // Failure! No magnetometer.
            Toast.makeText(this, "Fracasaras en la vida, ya que no existe el sensor de campo magnético",
                    Toast.LENGTH_SHORT).show();
            Log.i("MISENSORITO", "Fracasaras en la vida, ya que no existe el sensor de campo magnético");
        }




    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // The light sensor returns a single value.
        // Many sensors return 3 values, one for each axis.
        float lux = event.values[0];
        // Do something with this sensor value.
        txt.setText(String.valueOf(lux));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLight,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
