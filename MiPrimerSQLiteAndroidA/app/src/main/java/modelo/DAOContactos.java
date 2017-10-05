package modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by alcohonsilver on 05/10/17.
 */

public class DAOContactos {
    private  Context _contexto;
    private SQLiteDatabase _midb;

    public DAOContactos(Context contexto){
        this._contexto = contexto;
        this._midb = new MiDBOpenHelper(contexto).getWritableDatabase();
    }


    public boolean insert(Contacto c){

        ContentValues cv = new ContentValues();

        cv.put(MiDBOpenHelper.COLUMNS_CONTACTOS[1],c.getNombre());
        cv.put(MiDBOpenHelper.COLUMNS_CONTACTOS[2],c.getCorreo_electronico());
        cv.put(MiDBOpenHelper.COLUMNS_CONTACTOS[3],c.getTwitter());

        return _midb.insert(MiDBOpenHelper.TABLE_CONTACTOS_NAME,null,cv) > 0;

    }


}
