package com.example.medicaldevicesrental.Register;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLException;

public interface IRegister {
    void register(String user) throws SQLException, JSONException, ClassNotFoundException;
}
