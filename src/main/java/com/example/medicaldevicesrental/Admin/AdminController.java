package com.example.medicaldevicesrental.Admin;

import com.example.medicaldevicesrental.Connection.DataBase;
import com.example.medicaldevicesrental.Connection.DevicesDataBase;
import com.example.medicaldevicesrental.Connection.HospitalDataBase;
import com.example.medicaldevicesrental.Connection.UserDataBase;
import com.example.medicaldevicesrental.Register.IRegister;
import com.example.medicaldevicesrental.Register.RegisterController;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin
@RequestMapping("/api/admin")
@RestController
public class AdminController implements IAdmin{
    private DataBase dataBase;

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
    public void removeDevice(@RequestBody String id) throws SQLException, ClassNotFoundException, JSONException {
        JSONObject idObject = new JSONObject(id);
        dataBase = new DevicesDataBase();
        dataBase.delete(idObject);
    }

    @RequestMapping("updateDevice")
    @Override
    @PostMapping
    public void updateDevice(@RequestBody String device) throws SQLException, ClassNotFoundException, JSONException {
        JSONObject object = new JSONObject(device);
        dataBase = new DevicesDataBase();
        dataBase.update(object);
    }

    @RequestMapping("register")
    @PostMapping
    @Override
    public void register(@RequestBody String user) throws SQLException, JSONException, ClassNotFoundException {
        IRegister registerObject = new RegisterController();
        registerObject.register(user);
    }
}
