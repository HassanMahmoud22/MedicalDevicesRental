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
        preparedStmt.setString (1, (String) hospital.get("username"));
        preparedStmt.setString (2, (String) hospital.get("name"));
        preparedStmt.setDouble (3, (Double) hospital.get("address"));
        preparedStmt.setDouble (4, (Double) hospital.get("phone_number"));
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("Device added successfully");
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
    public void update(JSONObject jsonObject) throws JSONException, SQLException, ClassNotFoundException {

    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public JSONArray search(String string) throws SQLException, ClassNotFoundException, JSONException {
        return null;
    }


}
