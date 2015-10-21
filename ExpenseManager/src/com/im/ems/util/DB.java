/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.im.ems.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Nadun Liyanage
 */
public class DB {
    static String username = "root";
    static String password = "0147";
    static String url = "jdbc:mysql://localhost:3306/dbexpense";
    static String driver = "com.mysql.jdbc.Driver";
    
    static Connection con;
    
    public static Connection getCon() throws Exception{
        if(con==null){
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        }
        return con;
    }
}
