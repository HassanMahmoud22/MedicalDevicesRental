package com.example.medicaldevicesrental.Hospitals;

import com.example.medicaldevicesrental.Connection.DataBase;
import com.example.medicaldevicesrental.Connection.DevicesDataBase;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        database = new DevicesDataBase();
        return database.search(string).toString();
    }

    @RequestMapping("rentDevice")
    @GetMapping
    @Override
    public void rentDevice() {

    }

    @RequestMapping("buyDevice")
    @GetMapping
    @Override
    public void buyDevice() {

    }
}
