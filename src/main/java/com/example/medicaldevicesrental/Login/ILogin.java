package com.example.medicaldevicesrental.Login;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLException;

public interface ILogin {
    public boolean login(String user) throws JSONException, SQLException, ClassNotFoundException;
}
