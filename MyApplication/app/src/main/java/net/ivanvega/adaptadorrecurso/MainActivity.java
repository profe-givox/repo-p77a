package net.ivanvega.adaptadorrecurso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,0,"Relative Layout");
        menu.add(0,1,1,"Salir");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case 0:
                Toast.makeText(this,
                        item.getTitle(),
                        Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this,
                        item.getTitle(),
                        Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
