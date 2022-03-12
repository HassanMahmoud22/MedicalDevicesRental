package com.example.medicaldevicesrental.Admin;

import com.example.medicaldevicesrental.Connection.DataBase;
import com.example.medicaldevicesrental.Connection.DevicesDataBase;
import com.example.medicaldevicesrental.Connection.HospitalDataBase;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequestMapping("/api/admin")
@RestController
public class AdminController implements IAdmin{
    DataBase dataBase;

    @Autowired
    public AdminController(){}

    @RequestMapping("viewDevices")
    @Override
    @GetMapping
    public String viewDevices() throws SQLException, JSONException, ClassNotFoundException {
        dataBase = new DevicesDataBase();
        return dataBase.read().toString();
    }

    @RequestMapping("viewHospitals")
    @Override
    @GetMapping
    public String viewHospitals() throws SQLException, JSONException, ClassNotFoundException {
        dataBase = new HospitalDataBase();
        return dataBase.read().toString();
    }

    @RequestMapping("addDevice")
    @Override
    @PostMapping
    public void addDevice(@RequestBody String device) throws SQLException, JSONException, ClassNotFoundException {
        JSONObject object = new JSONObject(device);
        dataBase = new DevicesDataBase();
        dataBase.create(object);
    }

    @RequestMapping("removeDevice")
    @Override
    @PostMapping
    public void removeDevice(@RequestParam int id) throws SQLException, ClassNotFoundException {
        dataBase = new DevicesDataBase();
        dataBase.delete(id);
    }

    @RequestMapping("updateDevice")
    @Override
    @PostMapping
    public void updateDevice(@RequestBody String device) throws SQLException, ClassNotFoundException, JSONException {
        JSONObject object = new JSONObject(device);
        dataBase = new DevicesDataBase();
        dataBase.update(object);
    }
}
