package com.example.medicaldevicesrental.Connection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HospitalDataBase implements DataBase{

    @Override
    public void create(JSONObject hospital) throws JSONException, SQLException, ClassNotFoundException {
        String query = "INSERT INTO Hospitals(username, name, address, phone_number) VALUES(?,?,?,?) ";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setString (1, hospital.getString("username"));
        preparedStmt.setString (2, hospital.getString("name"));
        preparedStmt.setString (3, hospital.getString("address"));
        preparedStmt.setString (4, hospital.getString("phone_number"));
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("Hospital added successfully");
    }

    @Override
    public JSONArray read() throws SQLException, ClassNotFoundException, JSONException {
        JSONArray hospitals = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select * from Hospitals");
        while(rs.next())
        {
            JSONObject hospital = new JSONObject();
            hospital.put("username", rs.getString("username"));
            hospital.put("name", rs.getString("name"));
            hospital.put("address", rs.getString("address"));
            hospital.put("phone_number", rs.getString("phone_number"));
            hospitals.put(hospital);
        }
        return hospitals;
    }

    @Override
    public void update(JSONObject hospital) throws JSONException, SQLException, ClassNotFoundException {
        String query = "UPDATE hospitals SET username = ?, name = ?, address = ?, phone_number = ? WHERE username = ?";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setString(1, hospital.getString("username"));
        preparedStmt.setString(2, hospital.getString("name"));
        preparedStmt.setString(3, hospital.getString("address"));
        preparedStmt.setString(4, hospital.getString("phone_number"));
        preparedStmt.setString(5, hospital.getString("username"));
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("The Hospital is updated successfully");
    }

    @Override
    public void delete(JSONObject hospitalUsername) throws SQLException, ClassNotFoundException, JSONException {
        String query = " DELETE from hospitals WHERE username = '" + hospitalUsername.getString("username") +"'";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("The Hospital is Deleted successfully");
    }

    @Override
    public JSONArray search(JSONObject string) throws SQLException, ClassNotFoundException, JSONException {
        return null;
    }

    @Override
    public JSONObject search(String username) throws SQLException, ClassNotFoundException, JSONException {
        JSONObject hospital = new JSONObject();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select * from hospitals where username ='"+username+"'");
        if(rs.next())
        {
            hospital.put("username", rs.getString("username"));
            hospital.put("name", rs.getString("name"));
            hospital.put("address", rs.getString("address"));
            hospital.put("phone_number", rs.getString("phone_number"));
        }
        return hospital;
    }
}
