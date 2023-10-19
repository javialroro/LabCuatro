package lab4;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diemo
 */
public class AutoresAccess {
    
    
    public static String getAutores(){
        String str = "";
        try{
            Connection connection = SQLConnection.getConnection();
            Statement statement = null;
            statement = connection.createStatement();

            // Create and execute a SELECT SQL statement.
            String selectSql = "EXEC GET_AUTORES";
            ResultSet resultSet = null;

            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                str += resultSet.getString(1) +"\t" + 
                        resultSet.getString(2) +"\t" + 
                        resultSet.getString(3) +"\t" + 
                        resultSet.getString(4) +"\t" + 
                        resultSet.getString(5) + "\t" + 
                        resultSet.getString(6) +"\t" +
                        resultSet.getString(7) +"\t" +
                        resultSet.getString(8)
                        +"\n";
                
            }
            System.out.println(str);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return str;
    }
    
    public static String insertAutor(String idAutor, String nombre, 
    String idPais, String vivo,String fechaNacimiento, String primeraPublicacion,
    String publicaciones, String calificacion){
        String str = "";
        try{
            Connection connection = SQLConnection.getConnection();
            Statement statement = null;
            statement = connection.createStatement();
            String insertSql = "INSERT INTO [dbo].[Autores]\n" +
                "([idAutor], [nombre], [idPais], [vivo],[fechaNacimiento],[primeraPublicacion],[publicaciones],[calificacion]) \n" +
                " VALUES('"+idAutor+"', '"+nombre+"', '"+idPais+"', '"+vivo+"', '"+fechaNacimiento+
                "', '"+primeraPublicacion+"', '"+publicaciones+"', '"+calificacion+"');";

            PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS); 
            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            ResultSet resultSet = null;
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                str += resultSet.getString(1)+"\n";
                System.out.println("Generated: " + resultSet.getString(1));
            }
            
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return str;
    }
}
