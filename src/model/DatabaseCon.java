/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.*;
/**
 *
 * @author HP
 */
public class DatabaseCon {
  private static Connection con;
  public static Connection createDBConnection()
{   
    try {
        String path = "jdbc:mysql://localhost/library_management";
        con=DriverManager.getConnection(path, "root", "");
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }
    return con;
}  
    
}
