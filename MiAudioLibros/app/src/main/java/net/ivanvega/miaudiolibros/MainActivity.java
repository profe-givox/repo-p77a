package net.ivanvega.miaudiolibros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RecyclerView r_v;
    AdaptadorLibros adp ;
    RecyclerView.LayoutManager lmrv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_fragment_hardcode);

//        r_v = (RecyclerView)findViewById(R.id.recycler_view);
//        InfoGlobal info = InfoGlobal.getInstance();
//        info.inicializa(this);
//        adp = new AdaptadorLibros(this,
//                info.getVectorLibros() );
//        adp.setOnItemClickListerner(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplication(),
//                String.valueOf( r_v.getChildAdapterPosition((View)view)),
//                        Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        r_v.setAdapter(adp);
//
//
//        lmrv = new GridLayoutManager(this,2);
//        r_v.setLayoutManager(lmrv);




    }
}
