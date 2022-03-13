package com.example.medicaldevicesrental.Hospitals;

import com.example.medicaldevicesrental.Connection.DataBase;
import com.example.medicaldevicesrental.Connection.DevicesDataBase;
import com.example.medicaldevicesrental.Connection.DevicesTransactions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequestMapping("/api/hospital")
@RestController
public class HospitalController implements IHospital{
    DataBase database;

    @Autowired
    public HospitalController(){}

    @RequestMapping("searchDevice")
    @GetMapping
    @Override
    public String searchDevice(@RequestBody String string) throws SQLException, JSONException, ClassNotFoundException {
        JSONObject searchObject = new JSONObject(string);
        database = new DevicesDataBase();
        return database.search(searchObject).toString();
    }

    @RequestMapping("requestDevice")
    @GetMapping
    @Override
    public void requestDevice(@RequestBody String transaction) throws JSONException, SQLException, ClassNotFoundException {
        database = new DevicesTransactions();
        DataBase deviceDatabase = new DevicesDataBase();
        JSONObject transactionObject = new JSONObject(transaction);
        JSONObject device = deviceDatabase.search(transactionObject.getString("device_id"));
        device.put("amount", device.getInt("amount") - transactionObject.getInt("amount"));
        deviceDatabase.update(device);
        database.create(transactionObject);
    }
}
