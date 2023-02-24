package com.yasu.passwordmanager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        PasswordManager passwordManager = new PasswordManager();
        passwordManager.getPassword("test");
        System.out.println(passwordManager.toString());
    }
}
