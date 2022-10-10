package edu.mypet.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;

import java.sql.SQLException;

public class PoolConnectionBuilder implements ConnectionBuilder{
    private static final Logger logs= LoggerFactory.getLogger(PoolConnectionBuilder.class);
    private DataSource source;

    public PoolConnectionBuilder(){
        try {
            Context ctx = new InitialContext();
            source=(DataSource) ctx.lookup("java:comp/env/jdbc/areaSearcher");
        }catch(NamingException e){
            e.printStackTrace();
            logs.error("",e);
        }
        }
    @Override
    public Connection getConnection() throws SQLException {
        return source.getConnection();
    }
}
