package modelo;

import java.util.Date;

/**
 * Created by alcohonsilver on 05/10/17.
 */

class Contacto {
    int id;
    String nombre;
    String correo_electronico;
    String twitter;

    public int getId() {
        return id;
    }

    public Contacto(int id, String nombre, String correo_electronico, String twitter) {
        this.id = id;
        this.nombre = nombre;
        this.correo_electronico = correo_electronico;
        this.twitter = twitter;
    }

    public void setId(int id) {
        this.id = id;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    String telefono;
    Date fecha_nacimiento;


}
