package com.yasu.passwordmanager;

import java.sql.Date;

public class Users {
    private int id_user;
    private String name;
    private String username;
    private String password;
    private String email;
    private Date creation_date;
    private Date modified_date;

    public Users (int id_user, String name, String username, String password, String email, Date creation_date, Date modified_date){
        this.id_user = id_user;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.creation_date = creation_date;
        this.modified_date = modified_date;
    }
    public Users (int id_user, String username, String password, String email, Date creation_date){
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.email = email;
        this.creation_date = creation_date;
    }

}
