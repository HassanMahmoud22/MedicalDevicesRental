package com.example.medicaldevicesrental.Hospitals;

import com.example.medicaldevicesrental.Connection.*;
import com.example.medicaldevicesrental.Register.IRegister;
import com.example.medicaldevicesrental.Register.RegisterController;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin
@RequestMapping("/api/hospital")
@RestController
public class HospitalController implements IHospital{
    private DataBase database;

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

    @RequestMapping("register")
    @PostMapping
    @Override
    public void register(@RequestBody String user) throws JSONException, SQLException, ClassNotFoundException {
        System.out.println(user);
        IRegister registerObject = new RegisterController();
        registerObject.register(user);
        JSONObject hospitalObject = new JSONObject(user);
        database = new HospitalDataBase();
        database.create(hospitalObject);
    }
}
