package net.ivanvega.mismensajitossmsenandroid;

import android.content.IntentFilter;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText  txtcel, txtsms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtcel = findViewById(R.id.txtcel);
        txtsms = findViewById(R.id.txtsms);

        IntentFilter infil =
                new IntentFilter("android.provider.Telephony.SMS_RECEIVED");


        SMSReceiver smsr = new SMSReceiver();

        registerReceiver(smsr, infil);

    }

    public void btnEnviar_click(View v){

        SmsManager smsM = SmsManager.getDefault();
        smsM.sendTextMessage(
                txtcel.getText().toString(),
                null, txtsms.getText().toString(),
                null, null);

        Toast.makeText(getBaseContext(), "Mensaje Enviado",
                Toast.LENGTH_LONG).show();

    }


}
