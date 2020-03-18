/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbutility.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DbConnection {
    protected static Connection connection;
    
     public static Connection getConnection(){
        if (connection == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                
                //declare name of database on the  localhost
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokobuku","root","");
                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    return connection;
    }
    
    public static void main(String[] args) {
        
      DbConnection.getConnection();
    }
}
