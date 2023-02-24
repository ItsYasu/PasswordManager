package com.yasu.passwordmanager;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        PasswordManager passwordManager = new PasswordManager();
        //passwordManager.getallDatabyWebsiteName("pandasmurfs");

        Scanner sc = new Scanner(System.in);
        System.out.println("Website URL where you want to see your credentials");
        String weburl = sc.next();
        System.out.println("Type your username");
        String username = sc.next();
        passwordManager.getPasswordbyWebsiteUrl(weburl, username);

    }
}
