package org.example;

import java.sql.*;

public class EditAssetTransferIdFromDatabase {

    private static final String DB_URL = "jdbc:mysql://prmnxtuat.cqwjxsnjwzzj.ap-southeast-1.rds.amazonaws.com/prm_java"; // Replace with your DB URL
    private static final String DB_USERNAME = "uatreadonlydev";
    private static final String DB_PASSWORD = "uatreadonlydev#2019";

    public static int maxIdFromUatPrmJava() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT MAX(id) AS id FROM asset_transfer WHERE asset_id = 1";
            // Replace with your SQL query
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (resultSet.next()) {
                int maxId = resultSet.getInt("id");
                return maxId;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }
}
