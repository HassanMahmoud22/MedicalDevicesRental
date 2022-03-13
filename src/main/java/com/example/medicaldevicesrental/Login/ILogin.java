package com.example.medicaldevicesrental.Login;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public interface ILogin {
    public String login(String user) throws JSONException, SQLException, ClassNotFoundException;
}
