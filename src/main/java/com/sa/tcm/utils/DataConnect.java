package com.sa.tcm.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {
	public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tcm", "sadai", "sadai");
            return con;
        } catch (Exception ex) {
        	ex.printStackTrace();
            System.out.println("Database.getConnection() Error -->"
                    + ex.getMessage());
            return null;
        }
    }
 
    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}
