package by.it_academy.jd2.data;

import java.sql.*;

public class DaoFactory {

    private static DaoFactory daoFactory;


    private DaoFactory() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }


    public static Connection getConnectionBase() throws SQLException, ClassNotFoundException {

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/chat",
                    "postgres",
                    "vz1528153");
            return conn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public static DaoFactory getInstance(DatabaseName databaseName) throws ClassNotFoundException {
        switch (databaseName) {
            case POSTGRES: {
                if (daoFactory == null) {
                    daoFactory = new DaoFactory();
                }
                return daoFactory;
            }
            case MYSQL : {
                return null;
            }
        }
        throw new IllegalArgumentException("Database name is unknown");
    }

}