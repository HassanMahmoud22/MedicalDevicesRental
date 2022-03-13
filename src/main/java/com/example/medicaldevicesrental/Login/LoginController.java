package com.example.medicaldevicesrental.Login;

import com.example.medicaldevicesrental.Connection.DataBase;
import com.example.medicaldevicesrental.Connection.HospitalDataBase;
import com.example.medicaldevicesrental.Connection.UserDataBase;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@CrossOrigin
@RequestMapping("/api/loginPage")
@RestController
public class LoginController implements ILogin {
    private DataBase dataBase;

    @RequestMapping("login")
    @GetMapping
    @Override
    public String login(String user) throws JSONException, SQLException, ClassNotFoundException {
        JSONObject temp = new JSONObject(user);
        dataBase = new UserDataBase();
        JSONObject userObject = new JSONObject();
        userObject = dataBase.search(temp.getString("username"));
        if(userObject.length() != 0 && userObject.getString("password").equals(temp.getString("password")))
        {
            if(temp.getString("role").equals("admin"))
                return userObject.toString();
            else
            {
               dataBase = new HospitalDataBase();
               JSONObject hospital = dataBase.search(userObject.getString("username"));
               return hospital.toString();
            }
        }
        return "";
    }
}
