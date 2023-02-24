package com.yasu.passwordmanager;

import com.yasu.jdbc.DatabaseManager;

import java.sql.*;

public class PasswordManager {
    DatabaseManager databaseManager;
    private String contrasena;
    private int id;
    private Date fecha_creacion;
    private Date f_ult_modificacion;
    public PasswordManager(){

    }
    public void getPassword(String nombre) throws SQLException {
        Connection connection = DatabaseManager.getConnection(); //Obtenemos conexión a través del metodo getConnection()
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM CONTRASENAS WHERE contrasena = ?");//Se prepara sentencia SQL. Sustituimos ? por variable nombre.
        statement.setString(1, nombre); // establece el valor del marcador de posición en el ID de la contraseña especificado como parámetro del método.
        ResultSet resultSet = statement.executeQuery(); //ejecutamos consulta
        if(resultSet.next()){
            this.id = resultSet.getInt("id_contrasena");
            this.contrasena = resultSet.getString(("contrasena"));
            this.fecha_creacion = resultSet.getDate("fecha_creacion");
            this.f_ult_modificacion = resultSet.getDate("f_ult_modificacion");

            Password password1 = new Password(id,contrasena,fecha_creacion,f_ult_modificacion);
            System.out.println(password1);
        }
        resultSet.close();
        statement.close();
        connection.close();

    }
    @Override
    public String toString() {
        return "id: " + id + " password: " + contrasena + " fecha creacion: " +fecha_creacion + " fecha modificacion: " +f_ult_modificacion;
    }
}
