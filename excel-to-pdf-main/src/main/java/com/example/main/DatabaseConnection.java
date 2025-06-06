package com.example.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing PostgreSQL database connections
 */
public class DatabaseConnection {
    
    // Database connection parameters
    private static final String URL = "jdbc:postgresql://localhost:5432/store";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";
    
    static {
        try {
            // Load PostgreSQL driver explicitly
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load PostgreSQL driver: " + e.getMessage());
        }
    }
    
    /**
     * Get a connection to the PostgreSQL database
     * 
     * @return Connection object
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    /**
     * Close the database connection safely
     * 
     * @param connection Connection to close
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
    
    /**
     * Test the database connection
     * 
     * @return true if connection successful, false otherwise
     */
    public static boolean testConnection() {
        Connection conn = null;
        try {
            conn = getConnection();
            boolean isValid = conn != null && !conn.isClosed();
            if (isValid) {
                System.out.println("Successfully connected to PostgreSQL database");
            }
            return isValid;
        } catch (SQLException e) {
            System.err.println("Database connection test failed: " + e.getMessage());
            return false;
        } finally {
            closeConnection(conn);
        }
    }
}