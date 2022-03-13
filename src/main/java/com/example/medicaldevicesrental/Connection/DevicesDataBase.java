package com.example.medicaldevicesrental.Connection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DevicesDataBase implements DataBase {

    @Override
    public void create(JSONObject device) throws JSONException, SQLException, ClassNotFoundException {
        String query = "INSERT INTO Devices(device_name, device_description, state, objective, price, amount) VALUES(?,?,?,?,?,?) ";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setString (1, device.getString("device_name"));
        preparedStmt.setString (2, device.getString("device_description"));
        preparedStmt.setString (3, device.getString("state"));
        preparedStmt.setString (4, device.getString("objective"));
        preparedStmt.setDouble (5, device.getDouble("price"));
        preparedStmt.setInt (6, device.getInt("amount"));
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("The Device is added successfully");
    }

    @Override
    public JSONArray read() throws SQLException, ClassNotFoundException, JSONException {
        JSONArray devices = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select * from Devices");
        while(rs.next())
        {
            JSONObject device = new JSONObject();
            device.put("id", rs.getInt("id"));
            device.put("device_name", rs.getString("device_name"));
            device.put("device_description", rs.getString("device_description"));
            device.put("state", rs.getString("state"));
            device.put("objective", rs.getString("objective"));
            device.put("price", rs.getDouble("price"));
            device.put("amount", rs.getInt("amount"));
            devices.put(device);
        }
        return devices;
    }

    @Override
    public void update(JSONObject device) throws JSONException, SQLException, ClassNotFoundException {
        String query = "UPDATE Devices SET device_name = ?, device_description = ?, state = ?, objective = ?, price = ?, amount = ? WHERE id = ?";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setString(1, device.getString("device_name"));
        preparedStmt.setString(2, device.getString("device_description"));
        preparedStmt.setString(3, device.getString("state"));
        preparedStmt.setString(4, device.getString("objective"));
        preparedStmt.setDouble(5, device.getDouble("price"));
        preparedStmt.setInt   (6, device.getInt("amount"));
        preparedStmt.setInt   (7, device.getInt("id"));
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("The Device is updated successfully");
    }

    @Override
    public void delete(JSONObject id) throws SQLException, ClassNotFoundException, JSONException {
        String query = " DELETE from Devices WHERE id = '" +id.getInt("id") +"'";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("The Device is Deleted successfully");
    }

    @Override
    public JSONArray search(JSONObject searchObject) throws SQLException, ClassNotFoundException, JSONException {
        JSONArray devices = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM devices WHERE device_description regexp '(^|[[:space:]])"+searchObject.getString("search")+"([[:space:]]|$)' " +
                "OR device_name regexp '(^|[[:space:]])"+searchObject.getString("search")+"([[:space:]]|$)'" +
                "OR state regexp '(^|[[:space:]])"+searchObject.getString("search")+"([[:space:]]|$)'" +
                "OR objective regexp '(^|[[:space:]])"+searchObject.getString("search")+"([[:space:]]|$)';");
        while(rs.next())
        {
            JSONObject device = new JSONObject();
            device.put("id", rs.getInt("id"));
            device.put("device_name", rs.getString("device_name"));
            device.put("device_description", rs.getString("device_description"));
            device.put("state", rs.getString("state"));
            device.put("objective", rs.getString("objective"));
            device.put("price", rs.getDouble("price"));
            device.put("amount", rs.getInt("amount"));
            devices.put(device);
        }
        return devices;
    }

    @Override
    public JSONObject search(String id) throws SQLException, ClassNotFoundException, JSONException {
        JSONObject device = new JSONObject();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select * from Devices where id ='"+id+"'");
        if(rs.next())
        {
            device.put("id", rs.getInt("id"));
            device.put("device_name", rs.getString("device_name"));
            device.put("device_description", rs.getString("device_description"));
            device.put("state", rs.getString("state"));
            device.put("objective", rs.getString("objective"));
            device.put("price", rs.getDouble("price"));
            device.put("amount", rs.getInt("amount"));
        }
        return device;
    }
}
