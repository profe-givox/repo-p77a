package net.ivanvega.miaudiolibros;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import net.ivanvega.miaudiolibros.fragments.DetalleFragment;
import net.ivanvega.miaudiolibros.fragments.SelectorFragment;

public class MainActivity extends AppCompatActivity {
    RecyclerView r_v;
    AdaptadorLibros adp ;
    RecyclerView.LayoutManager lmrv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.containt_main);

        if ((findViewById(R.id.contenedor_pequeno) != null)
                &&
                (getSupportFragmentManager().findFragmentById(
                R.id.contenedor_pequeno) == null))
        {
            SelectorFragment primerFragment = new SelectorFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contenedor_pequeno, primerFragment)
                    .commit();
        }

    }

    public void mostrarDetalle(int id) {
        DetalleFragment detalleFragment = (DetalleFragment)
                getSupportFragmentManager().findFragmentById(R.id.detalle_fragment);
        if (detalleFragment != null) {
            detalleFragment.ponInfoLibro(id);
        } else {
            DetalleFragment nuevoFragment = new DetalleFragment();
            Bundle args = new Bundle();
            args.putInt(DetalleFragment.ARG_ID_LIBRO, id);
            nuevoFragment.setArguments(args);
            FragmentTransaction transaccion = getSupportFragmentManager()
                    .beginTransaction();
            transaccion.replace(R.id.contenedor_pequeno, nuevoFragment);
            transaccion.addToBackStack(null);
            transaccion.commit();
        }
    }
}
