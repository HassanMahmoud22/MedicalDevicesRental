package com.example.medicaldevicesrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MedicalDevicesRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalDevicesRentalApplication.class, args);
    }

}
