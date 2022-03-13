package com.example.medicaldevicesrental.Login;

import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;

@Service
public interface ILogin {
    public String login(@RequestBody String user) throws JSONException, SQLException, ClassNotFoundException;
}
