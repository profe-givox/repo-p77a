package net.ivanvega.misserviciosandroida;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by alcohonsilver on 25/01/18.
 */

public class MiIntentService extends IntentService {

    public MiIntentService() {
        super("MiIntentService");
    }

    /**
     * The IntentService calls this method from the default worker thread with
     * the intent that started the service. When this method returns, IntentService
     * stops the service, as appropriate.
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        // Normally we would do some work here, like download a file.
        // For our sample, we just sleep for 5 seconds.
        Log.d("MIINTENTSERVICE","ARRANCO LA TAREA TRABAJOSA");
        try {
            for(int i=0; i<60; i++){
                Log.d("MISERVIXIO", "CONTANDO... " + String.valueOf( i));
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            // Restore interrupt status.
            Thread.currentThread().interrupt();
        }
    }
}
