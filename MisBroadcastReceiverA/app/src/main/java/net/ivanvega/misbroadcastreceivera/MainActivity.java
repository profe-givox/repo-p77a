package net.ivanvega.misbroadcastreceivera;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter ifl =
                new IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED);

        ifl.addAction("android.intent.action.PHONE_STATE");

        //


        PhoneStateBroadcastReceiver psbr =
                new PhoneStateBroadcastReceiver();


        registerReceiver(psbr,ifl);


    }


}
