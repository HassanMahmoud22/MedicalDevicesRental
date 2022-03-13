package com.example.medicaldevicesrental.Connection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DevicesTransactions implements DataBase{


    @Override
    public void create(JSONObject transaction) throws JSONException, SQLException, ClassNotFoundException {
        String query = "INSERT INTO Devices_transactions(device_id, hospital_username, amount) VALUES(?,?,?) ";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setInt (1, transaction.getInt("device_id"));
        preparedStmt.setString (2, transaction.getString("hospital_username"));
        preparedStmt.setInt (3, transaction.getInt("amount"));
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("The Transaction is added successfully");
    }

    @Override
    public JSONArray read() throws SQLException, ClassNotFoundException, JSONException {
        JSONArray transactions = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select devices.device_name, devices.price, devices.state, devices.objective, Devices_transactions.* " +
                "from  devices, Devices_transactions where Devices_transactions.device_id = devices.id");
        while(rs.next())
        {
            JSONObject transaction = new JSONObject();
            transaction.put("id", rs.getInt("id"));
            transaction.put("device_id", rs.getInt("device_id"));
            transaction.put("hospital_username", rs.getString("hospital_username"));
            transaction.put("state", rs.getString("state"));
            transaction.put("objective", rs.getString("objective"));
            transaction.put("price", rs.getDouble("price"));
            transaction.put("transaction_date", rs.getDouble("transaction_date"));
            transaction.put("amount", rs.getInt("amount"));
            transaction.put("device_name", rs.getString("device_name"));
            transactions.put(transaction);
        }
        return transactions;
    }

    @Override
    public void update(JSONObject transaction) throws JSONException, SQLException, ClassNotFoundException {
        String query = "UPDATE Devices_transactions SET device_id = ?, hospital_username = ?, amount = ? WHERE id = ?";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setInt(1, transaction.getInt("device_id"));
        preparedStmt.setString(2, transaction.getString("hospital_username"));
        preparedStmt.setInt   (3, transaction.getInt("amount"));
        preparedStmt.setInt   (4, transaction.getInt("id"));
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("The transaction is updated successfully");
    }

    @Override
    public void delete(JSONObject id) throws SQLException, ClassNotFoundException, JSONException {
        String query = " DELETE from Devices_transactions WHERE id = '" +id.getInt("id") +"'";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("The Transaction is Deleted successfully");
    }

    @Override
    public JSONArray search(JSONObject searchObject) throws SQLException, ClassNotFoundException, JSONException {
        JSONArray transactions = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select devices.device_name, devices.price, devices.state, devices.objective, Devices_transactions.* " +
                "from  devices, Devices_transactions " + "where (Devices_transactions.device_id = devices.id) " +
                "and (devices.device_name regexp '(^|[[:space:]])"+searchObject.getString("search")+"([[:space:]]|$)' " +
                "OR devices.state regexp '(^|[[:space:]])"+searchObject.getString("search")+"([[:space:]]|$)' " +
                "OR devices.objective regexp '(^|[[:space:]])"+searchObject.getString("search")+"([[:space:]]|$)' " +
                "OR Devices_transactions.hospital_username regexp '(^|[[:space:]])"+searchObject.getString("search")+"([[:space:]]|$)');");
        while(rs.next())
        {
            JSONObject transaction = new JSONObject();
            transaction.put("id", rs.getInt("id"));
            transaction.put("device_id", rs.getInt("device_id"));
            transaction.put("hospital_username", rs.getString("hospital_username"));
            transaction.put("state", rs.getString("state"));
            transaction.put("objective", rs.getString("objective"));
            transaction.put("price", rs.getDouble("price"));
            transaction.put("transaction_date", rs.getDouble("transaction_date"));
            transaction.put("amount", rs.getInt("amount"));
            transaction.put("device_name", rs.getString("device_name"));
            transactions.put(transaction);
        }
        return transactions;
    }

    @Override
    public JSONObject search(String id) throws SQLException, ClassNotFoundException, JSONException {
        JSONObject transaction = new JSONObject();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select devices.device_name, devices.price, devices.state, devices.objective, Devices_transactions.* " +
                "from  devices, Devices_transactions " + "where (Devices_transactions.device_id = devices.id and Devices_transactions.id = '"+id+"');");
        if(rs.next())
        {
            transaction.put("id", rs.getInt("id"));
            transaction.put("device_id", rs.getInt("device_id"));
            transaction.put("hospital_username", rs.getString("hospital_username"));
            transaction.put("state", rs.getString("state"));
            transaction.put("objective", rs.getString("objective"));
            transaction.put("price", rs.getDouble("price"));
            transaction.put("transaction_date", rs.getDouble("transaction_date"));
            transaction.put("amount", rs.getInt("amount"));
            transaction.put("device_name", rs.getString("device_name"));
        }
        return transaction;
    }
}
