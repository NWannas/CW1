;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;
/**
 *
 * @author Rando
 */
public class Premium {
    
    Connection conn = null;
    public Connection connectdb(){
    try{
        
        Connection conn = null;
        String dbm = "products";
        String pass = "";
        String user = "root";
        String url = "jdbc:mysql://localhost:3306/";
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        conn = DriverManager.getConnection(url+dbm,user,pass);
       return conn;
    
    }
catch(Exception e){
JOptionPane.showMessageDialog(null, e.getMessage());
return null;
}
}
    
}
