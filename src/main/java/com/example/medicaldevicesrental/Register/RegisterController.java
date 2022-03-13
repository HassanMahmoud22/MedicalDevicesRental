package com.example.medicaldevicesrental.Register;

import com.example.medicaldevicesrental.Connection.DataBase;
import com.example.medicaldevicesrental.Connection.UserDataBase;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

public class RegisterController implements IRegister{
    private DataBase database;

    @Autowired
    public RegisterController(){}

    public void register(String user) throws SQLException, JSONException, ClassNotFoundException {
        JSONObject userObject = new JSONObject(user);
        database = new UserDataBase();
        database.create(userObject);
    }
}
