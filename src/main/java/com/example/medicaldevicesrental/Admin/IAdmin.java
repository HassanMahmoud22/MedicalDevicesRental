package com.example.medicaldevicesrental.Admin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;

public interface IAdmin {
    public String viewDevices() throws SQLException, JSONException, ClassNotFoundException;
    public String viewHospitals() throws SQLException, JSONException, ClassNotFoundException;
    public void addDevice(@RequestBody String device) throws SQLException, JSONException, ClassNotFoundException;
    public void removeDevice(@RequestBody String id) throws SQLException, ClassNotFoundException, JSONException;
    public void updateDevice(@RequestBody String device) throws SQLException, ClassNotFoundException, JSONException;
}
