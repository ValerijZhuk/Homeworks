package core.dto;

import java.sql.*;

public class ConnectionBase {

    public Connection getConnection() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "vz1528153");

            return conn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }



}