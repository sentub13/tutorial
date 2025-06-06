package com.example.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Main application class
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println("Testing PostgreSQL Connection...");
        
        // Test database connection
        if (DatabaseConnection.testConnection()) {
            System.out.println("Database connection successful!");
            
            // Example of executing a simple query
            executeExampleQuery();
        } else {
            System.out.println("Failed to connect to the database. Please check your connection settings.");
        }
    }
    
    /**
     * Example method to demonstrate a simple database query
     */
    private static void executeExampleQuery() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // Get database connection
            conn = DatabaseConnection.getConnection();
            stmt = conn.createStatement();
            
            // Example query - replace with your actual table
            String sql = "SELECT version()";
            rs = stmt.executeQuery(sql);
            
            // Process results
            if (rs.next()) {
                System.out.println("PostgreSQL version: " + rs.getString(1));
            }
            
        } catch (SQLException e) {
            System.err.println("Database query error: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
            
            // Close connection
            DatabaseConnection.closeConnection(conn);
        }
    }
}