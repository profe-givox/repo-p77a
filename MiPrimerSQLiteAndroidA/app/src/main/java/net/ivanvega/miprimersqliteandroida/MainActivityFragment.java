package net.ivanvega.miprimersqliteandroida;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import modelo.Contacto;
import modelo.DAOContactos;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    ListView lsvC;

    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        DAOContactos dao = new DAOContactos(getActivity());
        dao.insert(new Contacto(0,"El perro negro","perronegro@","@perronegro"));
        dao.insert(new Contacto(0,"El black dog","blackdog@","@blackdog"));



        View v = inflater.inflate(R.layout.fragment_main, container, false);


        lsvC = v.findViewById(R.id.lsvContactos);

        ArrayAdapter<Contacto> adp = new ArrayAdapter<Contacto>(getContext(),
                android.R.layout.simple_list_item_1,dao.getAll());

        lsvC.setAdapter(adp);

        return v;
    }
}
