package net.ivanvega.misbroadcastreceivera;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by alcohonsilver on 15/02/18.
 */

public class PhoneStateBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent i=intent;




         Log.d("ESTADOTELEFONIA",
                 i.getStringExtra(TelephonyManager.EXTRA_STATE));

    }



}
