package com.example.medicaldevicesrental.Connection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDataBase implements DataBase{
    @Override
    public void create(JSONObject user) throws JSONException, SQLException, ClassNotFoundException {
        String query = "INSERT INTO users(username, password, role) VALUES(?,?,?) ";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setString (1, user.getString("username"));
        preparedStmt.setString (2, user.getString("password"));
        preparedStmt.setString (3, user.getString("role"));
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("The user is added successfully");
    }

    @Override
    public JSONArray read() throws SQLException, ClassNotFoundException, JSONException {
        JSONArray users = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select * from users");
        while(rs.next())
        {
            JSONObject user = new JSONObject();
            user.put("username", rs.getString("username"));
            user.put("password", rs.getString("password"));
            user.put("role", rs.getString("role"));
            users.put(user);
        }
        return users;
    }

    @Override
    public void update(JSONObject user) throws JSONException, SQLException, ClassNotFoundException {
        String query = "UPDATE users SET username = ?, password = ?, role = ? WHERE username = ?";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.setString(1, user.getString("username"));
        preparedStmt.setString(2, user.getString("password"));
        preparedStmt.setString(3, user.getString("role"));
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("The user is updated successfully");
    }

    @Override
    public void delete(JSONObject username) throws SQLException, ClassNotFoundException, JSONException {
        String query = " DELETE from users WHERE username = '" +username.getString("username") +"'";
        PreparedStatement preparedStmt = establish_connection().prepareStatement(query);
        preparedStmt.executeUpdate();
        establish_connection().close();
        System.out.println("The user is Deleted successfully");
    }

    @Override
    public JSONArray search(JSONObject searchObject) throws SQLException, ClassNotFoundException, JSONException {
        JSONArray users = new JSONArray();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE username regexp '(^|[[:space:]])"+searchObject.getString("search")+"([[:space:]]|$)' " +
                "OR role regexp '(^|[[:space:]])"+searchObject.getString("search")+"([[:space:]]|$)'" +
                "OR password regexp '(^|[[:space:]])"+searchObject.getString("search")+"([[:space:]]|$)';");
        while(rs.next())
        {
            JSONObject user = new JSONObject();
            user.put("username", rs.getString("username"));
            user.put("password", rs.getString("password"));
            user.put("search", rs.getString("search"));
            users.put(user);
        }
        return users;
    }

    @Override
    public JSONObject search(String username) throws SQLException, ClassNotFoundException, JSONException {
        JSONObject user = new JSONObject();
        Statement statement = establish_connection().createStatement();
        ResultSet rs = statement.executeQuery("select * from users where username ='"+username+"'");
        if(rs.next())
        {
            user.put("username", rs.getString("username"));
            user.put("password", rs.getString("password"));
            user.put("role", rs.getString("role"));
        }
        return user;
    }
}
