package com.yasu.passwordmanager;

import java.sql.Date;

public class Password {
    private int id;
    private String contrasena;
    private Date fecha_creacion;
    private Date fecha_ult_mod;
    public Password(){

    }
    public Password(int id, String contrasena, Date fecha_creacion, Date fecha_ult_mod) {
        this.id = id;
        this.contrasena = contrasena;
        this.fecha_creacion = fecha_creacion;
        this.fecha_ult_mod = fecha_ult_mod;
    }


}
