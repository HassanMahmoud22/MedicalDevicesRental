package com.example.medicaldevicesrental.Hospitals;

import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;

public interface IHospital {
    public String searchDevice(String string) throws SQLException, JSONException, ClassNotFoundException;
    public void requestDevice(@RequestBody String rentTransaction) throws JSONException, SQLException, ClassNotFoundException;
}
