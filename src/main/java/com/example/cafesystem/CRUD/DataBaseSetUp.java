package com.example.cafesystem.CRUD;

import java.sql.*;

public class DataBaseSetUp {

    private static final String DATABASE_LOCATION = "jdbc:sqlite:database.db";
    private Connection connection;

    //making a connection and creating one if it doesn't exist
    public void createConnection(){
        try {
            if(connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DATABASE_LOCATION);
                System.out.println("Connection created.");
            }
        } catch (SQLException e) {
            System.err.println("Failed to create connection: " + e.getMessage());
        }
    }

    public  Connection getConnection(){
        return connection;
    }

    //updating the database base after every command
    private void updateDatabase(String sqlCommand){
        try (Statement statement = connection.createStatement()){
            if (connection != null && !connection.isClosed()) {
                statement.executeUpdate(sqlCommand);
                System.out.println("Database Updated Successfully");
            }else{
                System.out.println("Cannot connect to database");
            }
        } catch (SQLException e) {
            System.err.println("Failed to update database: " + e.getMessage());
        }
    }

//disconnect database from the api
    public void stopConnection(){
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Failed to close connection: " + e.getMessage());
        }
    }

    //using a sql command inform of string create a table
    public void runSQLQuery(String sqlCommand){
        createConnection();
        System.out.println("Query successful");
        updateDatabase(sqlCommand);
    }

    //using a sql command inform of string create a table
    public void createTable(String sqlCommand){
        runSQLQuery(sqlCommand);
    }

    //Deleting table
    public void deleteTable(String tableName){
        createConnection();
        String sqlCommand = "DROP TABLE IF EXISTS " + tableName;
        System.out.println("Table deleted");
        updateDatabase(sqlCommand);

    }

}

