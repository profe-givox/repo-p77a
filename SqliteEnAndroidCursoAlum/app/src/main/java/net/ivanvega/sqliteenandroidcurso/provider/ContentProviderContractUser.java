package net.ivanvega.sqliteenandroidcurso.provider;

/**
 * Created by alcohonsilver on 02/02/18.
 */

public class ContentProviderContractUser {
    public  static final String CONTENT_URI =
            "content://net.ivanvega.sqliteenandroidcurso.provider/usuario";

    public static  final String FIELD_ID = "_id";
    public static  final String FIELD_NOMBRE = "nombre";
    public static  final String FIELD_EMAIL = "email";
    public static  final String FIELD_PASS = "contrasenia";
}
