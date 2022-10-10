package edu.mypet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OneConnectionBuilderTest implements ConnectionBuilder{
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/area_searcher",
                "postgres",
                "TERMIT006WIN"
        );

    }
}
