package com.example.cafesystem.Models;

import com.example.cafesystem.CRUD.DataBaseSetUp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashMap;

public class SqlQueries {

    DataBaseSetUp dataBaseSetUp = new DataBaseSetUp();

    public static String CREATE_MENU_ITEMS_TABLE = "CREATE TABLE MenuItems (" +
            "menu_item_id INTEGER PRIMARY KEY," +
            "name VARCHAR(100) NOT NULL," +
            "description TEXT," +
            "price DECIMAL(10, 2) NOT NULL," +
            "category VARCHAR(50)," +
            "is_available BOOLEAN DEFAULT 1" +
            ")";

    public static String CREATE_ORDER_ITEMS_TABLE = "CREATE TABLE OrderItems (" +
            "order_item_id INTEGER PRIMARY KEY," +
            "order_id INTEGER," +
            "menu_item_id INTEGER," +
            "quantity INTEGER NOT NULL," +
            "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "completed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "FOREIGN KEY (order_id) REFERENCES Orders(order_id)," +
            "FOREIGN KEY (menu_item_id) REFERENCES MenuItems(menu_item_id)" +
            ")";

    public static String CREATE_CUSTOMER_EVENTS_TABLE = "CREATE TABLE CustomerEvents (" +
            "customer_event_id INTEGER PRIMARY KEY," +
            "customer_id INTEGER," +
            "event_id INTEGER," +
            "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)," +
            "FOREIGN KEY (event_id) REFERENCES Events(event_id)" +
            ")";


    public static String CREATE_CUSTOMERS_TABLE = "CREATE TABLE Customers (" +
            "customer_id INTEGER PRIMARY KEY," +
            "first_name VARCHAR(100) NOT NULL," +
            "last_name VARCHAR(100) NOT NULL," +
            "date_of_birth DATE NOT NULL," +
            "address VARCHAR(255) NOT NULL," +
            "password TEXT NOT NULL," +
            "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
            ")";

    public static String CREATE_ORDERS_TABLE = "CREATE TABLE Orders (" +
            "order_id INTEGER PRIMARY KEY," +
            "customer_id INTEGER," +
            "order_type VARCHAR(100) NOT NULL," +
            "order_status VARCHAR(100) NOT NULL," +
            "pickup_time TIMESTAMP," +
            "delivery_address VARCHAR(255)," +
            "delivery_time TIMESTAMP," +
            "driver_id INTEGER," +
            "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
            // "FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)," +
            //"FOREIGN KEY (driver_id) REFERENCES Staff(staff_id)," +
            ")";

    public static String CREATE_BOOKINGS_TABLE = "CREATE TABLE Bookings (" +
            "booking_id INTEGER PRIMARY KEY," +
            "customer_id INTEGER," +
            "table_id INTEGER," +
            "number_of_guests INTEGER NOT NULL," +
            "booking_date DATE NOT NULL," +
            "booking_time TIME NOT NULL," +
            "duration INTEGER DEFAULT 60," +
            "status VARCHAR(50) NOT NULL," +
            "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
            //"FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)," +
            // "FOREIGN KEY (table_id) REFERENCES Tables(table_id)," +
            ");";


    public static String CREATE_STAFF_TABLE = "CREATE TABLE Staff (" +
            "staff_id INTEGER PRIMARY KEY," +
            "first_name VARCHAR(100) NOT NULL," +
            "last_name VARCHAR(100) NOT NULL," +
            "password TEXT NOT NULL," +
            "role VARCHAR(50) NOT NULL," +
            "work_hours INTEGER," +
            "total_hours_worked INTEGER DEFAULT 0," +
            "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
            ")";

    public static String CREATE_TABLES_TABLE = "CREATE TABLE Tables (" +
            "table_id INTEGER PRIMARY KEY," +
            "capacity INTEGER NOT NULL," +
            "availability BOOLEAN DEFAULT 1," +
            "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
            ")";

    public static String CREATE_EVENTS_TABLE = "CREATE TABLE Events (" +
            "event_id INTEGER PRIMARY KEY," +
            "title VARCHAR(100) NOT NULL," +
            "event_type VARCHAR(50) NOT NULL," +
            "date DATE NOT NULL," +
            "time TIME NOT NULL," +
            "tables_required INTEGER NOT NULL," +
            "max_attendees INTEGER NOT NULL," +
            "description TEXT," +
            "additional_requirements TEXT," +
            "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
            ")";

    public static String CREATE_REPORTS_TABLE = "CREATE TABLE Reports (" +
            "report_id INTEGER PRIMARY KEY," +
            "report_type VARCHAR(50) NOT NULL," +
            "report_content TEXT NOT NULL," +
            "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
            ")";

    public void createCustomer() {
        String customer = "CREATE TABLE Customer (" +
                "customer_id INTEGER PRIMARY KEY," +
                "isLoyaltyMember BOOLEAN NOT NULL," +
                "loyaltyPoints INTEGER DEFAULT 0," +
                "userID INTEGER NOT NULL," +
                "FOREIGN KEY (userID) REFERENCES User(userID));";
        dataBaseSetUp.createConnection();
        try {
            Statement stmt = dataBaseSetUp.getConnection().createStatement();
            stmt.executeUpdate(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Alter table statements to add password column
    public void addColumn(String tableName, String column, String dataType) {
        dataBaseSetUp.createConnection();
        String addColumn = "ALTER TABLE " + tableName + " ADD COLUMN " + column + " " + dataType + " NOT NULL";
        dataBaseSetUp.runSQLQuery(addColumn);
    }


    public void dropColumn(String tableName, String column) {
        String dropColumn = "ALTER TABLE " + tableName + " DROP COLUMN " + column;
        dataBaseSetUp.runSQLQuery(dropColumn);
    }

    public void readRecord(String tableName, String rowIdentifier, String availableEntry) {
        String read = "Select * from " + tableName + " WHERE " + rowIdentifier + " IS " + availableEntry;
        dataBaseSetUp.createConnection();

    }

    public void insertNewRecord(String tableName, HashMap<String, Object> entries) {
        if (entries.isEmpty()) {
            throw new IllegalArgumentException("Entries cannot be empty.");
        }

        dataBaseSetUp.createConnection();

        String columnNames = String.join(", ", entries.keySet());
        String placeHolders = String.join(", ", Collections.nCopies(entries.size(), "?"));
        String sqlCommand = String.format("INSERT INTO %s(%s) VALUES (%s)", tableName, columnNames, placeHolders);

        try (PreparedStatement preparedStatement = dataBaseSetUp.getConnection().prepareStatement(sqlCommand)) {

            int index = 1;
            for (Object value : entries.values()) {
                preparedStatement.setObject(index++, value);
            }
            preparedStatement.executeUpdate();
            preparedStatement.close();

            System.out.println("Successfully inserted record into " + tableName + "!");
        } catch (SQLException e) {
            System.err.println("Failed to insert record into " + tableName + ": " + e.getMessage());

        } finally {
            dataBaseSetUp.stopConnection();
        }
    }

    public void deleteRecord(String tableName, Object recordID) throws SQLException {
        dataBaseSetUp.createConnection();
        String sqlCode = "Delete from " + tableName + " WHERE menu_item_id = ?";

        try (PreparedStatement preparedStatement = dataBaseSetUp.getConnection().prepareStatement(sqlCode)) {
            preparedStatement.setObject(1, recordID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            dataBaseSetUp.stopConnection();
        }
    }
}
