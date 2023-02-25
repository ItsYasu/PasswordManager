package com.yasu.passwordmanager;

import com.yasu.jdbc.DatabaseManager;

import java.sql.*;

public class PasswordManager {
    DatabaseManager databaseManager;
    private String username_website;
    private String password_website;
    private String email;
    private String website_name;
    private String website_url;
    private int id_password;
    private int id_user;
    private Date fecha_creacion;
    private Date f_ult_modificacion;

    public PasswordManager() {

    }

    /*
    @param websiteurl -> set the website URL that you want to search your credentials
    @param username -> set your application username
    This method returns a username and password of a desired website.
     */
    public void getCredentialsByWebsiteUrl(String websiteurl, String username) throws SQLException {
        Connection connection = DatabaseManager.getConnection(); //Connection to the database
        PreparedStatement statement = connection.prepareStatement("SELECT username_website, password_website from passwords p, users u where p.website_url = ? and u.id_user = p.id_user and u.username = ?"); //SQL Query
        statement.setString(1, websiteurl); //Setting the position of the mark "?" in the query
        statement.setString(2, username);
        ResultSet resultSet = statement.executeQuery(); //Executing query

        while (resultSet.next()) { //Loop to check if there's more than one password saved for X website
            this.username_website = resultSet.getString("username_website");
            this.password_website = resultSet.getString("password_website");

            System.out.println("Username of this website: " + username_website); //Printing username
            System.out.println("Password of this website: " + password_website); //Printing password
        }
        resultSet.close();
        statement.close();
        connection.close();


    }

    public void getallDatabyWebsiteName(String nombre) throws SQLException {
        Connection connection = DatabaseManager.getConnection(); //Obtenemos conexión a través del metodo getConnection()
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM passwords WHERE website_name = ?");//Se prepara sentencia SQL. Sustituimos ? por variable nombre.
        statement.setString(1, nombre); // establece el valor del marcador de posición en el ID de la contraseña especificado como parámetro del método.
        ResultSet resultSet = statement.executeQuery(); //ejecutamos consulta
        while (resultSet.next()) {
            this.id_password = resultSet.getInt("id_password");
            this.id_user = resultSet.getInt("id_user");
            this.website_url = resultSet.getString("website_url");
            this.website_name = resultSet.getString("website_name");
            this.username_website = resultSet.getString("username_website");
            this.password_website = resultSet.getString(("password_website"));
            this.email = resultSet.getString("email");
            this.fecha_creacion = resultSet.getDate("creation_date");
            this.f_ult_modificacion = resultSet.getDate("last_modify_date");

            StringBuilder sb = new StringBuilder();
            sb.append("ID_Password: " + this.id_password + " ");
            sb.append("ID_User: " + this.id_user + " ");
            sb.append("Website URL: " + this.website_url + " ");
            sb.append("Website Name: " + this.website_name + " ");
            sb.append("Username on website: " + this.username_website + " ");
            sb.append("Password on website: " + this.password_website + " ");
            sb.append("Email on website: " + this.email + " ");
            sb.append("Fecha de creación: " + this.fecha_creacion + " ");
            sb.append("Fecha Última Modificación: " + this.f_ult_modificacion + " ");
            System.out.println(sb.toString());
        }
        resultSet.close();
        statement.close();
        connection.close();

    }
}
