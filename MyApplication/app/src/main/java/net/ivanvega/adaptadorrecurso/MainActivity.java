package net.ivanvega.adaptadorrecurso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lsv ;
    String[] arraypresidentes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsv = (ListView)findViewById(R.id.lsv);

        arraypresidentes =
                getResources().getStringArray(R.array.presidentes);

        ArrayAdapter<String> adp =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        arraypresidentes);

        lsv.setAdapter(adp);

    }
}
