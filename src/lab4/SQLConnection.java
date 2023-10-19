package lab4;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diemo
 */
public class SQLConnection {
    
    private static final String connectionString =
                "jdbc:sqlserver://JAVITO:1433;"
                + "database=LIBRERIA;"
                + "user=JAVI;"
                + "password=1234;"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";

    private SQLConnection() {
    }
    
    public static Connection getConnection(){
        try {
            Connection connection;
            connection = DriverManager.getConnection(connectionString);
            return connection;
        } catch (SQLException ex) {}
        return null;
    }
    
    
}
