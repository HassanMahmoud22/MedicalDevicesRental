package com.example.medicaldevicesrental.Hospitals;

import org.json.JSONException;

import java.sql.SQLException;

public interface IHospital {
    String searchDevice(String string) throws SQLException, JSONException, ClassNotFoundException;
    public void rentDevice();
    public void buyDevice();
}
