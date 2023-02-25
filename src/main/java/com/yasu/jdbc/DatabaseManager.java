package com.yasu.jdbc;

    import java.sql.*;

        public class DatabaseManager {
            private static Connection connection;
            private static String url = "jdbc:mysql://localhost:3306/passwordmanager?serverTimezone=UTC";
            private static String username = "root";
            private static String password = "INSERT HERE";
            private static Statement statement;
        public static Connection getConnection() {
            if (connection == null) {
                try {
                    connection = DriverManager.getConnection(url,username,password);
                    statement = connection.createStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }return connection;

        }

        public static void closeConnection() {
            if (connection != null) {
                try {
                    connection.close();
                    connection = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
