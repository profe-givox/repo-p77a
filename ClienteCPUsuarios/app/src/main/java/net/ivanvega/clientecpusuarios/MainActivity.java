package net.ivanvega.clientecpusuarios;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    ListView lsvCCP ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsvCCP = findViewById(R.id.lsv);



    }


    public void   btnCCP_click (View v)
    {
        Cursor c  = getContentResolver().query (Uri.parse(  ContentProviderContractUser.CONTENT_URI ),
                null,null,null,null );

        SimpleCursorAdapter sca = new SimpleCursorAdapter
                (this, android.R.layout.simple_list_item_2,
                        c,
                        new String[]{
                            ContentProviderContractUser.FIELD_ID,
                                ContentProviderContractUser.FIELD_NOMBRE
                        },
                        new int[]{android.R.id.text1,android.R.id.text2},
                        SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
                        );

        lsvCCP.setAdapter(sca);


    }
}

