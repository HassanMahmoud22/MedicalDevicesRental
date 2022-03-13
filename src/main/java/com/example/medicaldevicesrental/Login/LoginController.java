package com.example.medicaldevicesrental.Login;

import com.example.medicaldevicesrental.Connection.DataBase;
import com.example.medicaldevicesrental.Connection.UserDataBase;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLException;

public class LoginController implements ILogin {
    private DataBase dataBase;
    public boolean login(String user) throws JSONException, SQLException, ClassNotFoundException {
        JSONObject temp = new JSONObject(user);
        dataBase = new UserDataBase();
        JSONObject userObject = new JSONObject();
        userObject = dataBase.search(temp.getString("username"));
        if(userObject.length() != 0 && userObject.getString("password").equals(temp.getString("password")))
            return true;
        return false;
    };
}
