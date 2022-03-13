package com.example.medicaldevicesrental.Login;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLException;

public interface ILogin {
    public String login(String user) throws JSONException, SQLException, ClassNotFoundException;
}
