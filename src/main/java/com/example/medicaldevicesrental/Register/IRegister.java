package com.example.medicaldevicesrental.Register;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

public interface IRegister {
    void register(String user) throws SQLException, JSONException, ClassNotFoundException;
}
