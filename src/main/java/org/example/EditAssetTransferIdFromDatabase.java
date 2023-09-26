package org.example;

import java.sql.*;

public class EditAssetTransferIdFromDatabase {

    private static final String DB_URL = "jdbc:mysql://prmqa.c52ts19mxvtt.ap-south-1.rds.amazonaws.com/prm_product_qa"; // Replace with your DB URL
    private static final String DB_USERNAME = "dvQAuser";
    private static final String DB_PASSWORD = "d%u$r#2021";
    public static void main(String[] args) throws SQLException
    {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT * FROM assets_master WHERE id = 1"; // Replace with your SQL query
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        // Process the database results
        while (resultSet.next()) {
            int assetId = resultSet.getInt("id");
            String assetName = resultSet.getString("name");
            System.out.println(assetId + " and " + assetName);
        }
    }
}
