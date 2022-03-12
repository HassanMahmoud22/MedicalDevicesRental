package com.example.medicaldevicesrental.Connection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DataBase {
    default Connection establish_connection() throws SQLException, ClassNotFoundException {
        //String url="jdbc:mysql://b15ac2a343b8b9:35b36f26@eu-cdbr-west-02.cleardb.net/heroku_9bd1e1239aac862?reconnect=true";
        String url = "jdbc:mysql://localhost:3306/MedicalDevicesRental";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection(url,"root","root");
        return connection;
    }
    public void create(JSONObject jsonObject) throws JSONException, SQLException, ClassNotFoundException;
    public JSONArray read() throws SQLException, ClassNotFoundException, JSONException;
    public void update(JSONObject jsonObject) throws JSONException, SQLException, ClassNotFoundException;
    public void delete(int id) throws SQLException, ClassNotFoundException;
    public JSONArray search(String string) throws SQLException, ClassNotFoundException, JSONException;
}
