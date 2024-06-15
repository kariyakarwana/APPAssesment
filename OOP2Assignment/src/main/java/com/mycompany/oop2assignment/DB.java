/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop2assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sandaruwan
 */
public class DB {
    private String url="jdbc:mysql://localhost:3306/trackings?zeroDateTimeBehavior=CONVERT_TO_NULL";
        private String un="root";
        private String pw="";
        private Connection con;
        
        public Connection getCon(){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con= DriverManager.getConnection(url,un,pw);
                System.out.println("Sucessful");
                
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
            catch(ClassNotFoundException ex){
                
            }
            return con;
        }
        
        public void closeCon(){
            if(con!=null){
                try{
                    con.close();
                }
                catch(SQLException ex){
                    Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }

        public void execute(String query){
            con=getCon();
            try{
                Statement stmt=(Statement)con.createStatement();
                stmt.executeUpdate(query);
                con.close();
            }
            catch(SQLException ex){
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        public void getData(String query){
            con= getCon();
            try{
                Statement stmt =(Statement)con.createStatement();
                stmt.executeUpdate(query);
                ResultSet rs=stmt.executeQuery(query);
                
                while(rs.next())System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
                con.close();
            }
            catch(SQLException ex){
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
}
