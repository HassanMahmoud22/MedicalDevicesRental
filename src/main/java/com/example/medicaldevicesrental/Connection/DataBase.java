package com.example.medicaldevicesrental.Connection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DataBase {
    default Connection establish_connection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://b2d49ae5270dbf:414e55c9@us-cdbr-east-05.cleardb.net/heroku_9a58b6e4b09aa09?reconnect=true";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection(url,"b2d49ae5270dbf","414e55c9");
        return connection;
    }
    public void create(JSONObject jsonObject) throws JSONException, SQLException, ClassNotFoundException;
    public JSONArray read() throws SQLException, ClassNotFoundException, JSONException;
    public void update(JSONObject jsonObject) throws JSONException, SQLException, ClassNotFoundException;
    public void delete(JSONObject id) throws SQLException, ClassNotFoundException, JSONException;
    public JSONArray search(JSONObject string) throws SQLException, ClassNotFoundException, JSONException;
    public JSONObject search(String uniqueValue) throws SQLException, ClassNotFoundException, JSONException;

}
