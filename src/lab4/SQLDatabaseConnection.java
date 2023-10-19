
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabaseConnection {

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        String connectionUrl =
                "jdbc:sqlserver://JAVITO:1433;"
                + "database=LIBRERIA;"
                + "user=JAVI;"
                + "password=1234;"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";

        ResultSet resultSet = null;// es la estructura de datos donde queda el resultado de la consulta

        try (Connection connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "EXEC GET_LIBROS";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " " +resultSet.getString(3));
                //System.out.println();
            }
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
    }
}