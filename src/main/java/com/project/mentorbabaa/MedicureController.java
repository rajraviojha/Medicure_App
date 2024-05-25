package com.project.mentorbabaa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicureController {

    @Autowired
    MedicureService doctorService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Doctor Shubham";
    }

    @GetMapping("/createDoctor")
    public Doctor createDoctor() {
        return doctorService.createDoctor();
    }

    @PostMapping("/registerDoctor")
    public Doctor registerDoctor(@RequestBody Doctor doctor) {
        return doctorService.registerDoctor(doctor);
    }

    @PutMapping("/updateDoctor/{doctorRegNo}")
    public Doctor updateDoctor(@PathVariable String doctorRegNo, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(doctorRegNo, doctor);
    }

    @GetMapping("/getDoctor/{doctorRegistrationId}")
    public Doctor getDoctor(@PathVariable String doctorRegistrationId) {
        return doctorService.getDoctorDetails(doctorRegistrationId);
    }

    @GetMapping("/searchDoctor/{doctorName}")
    public List<Doctor> searchDoctor(@PathVariable String doctorName) {
        return doctorService.searchDoctor(doctorName);
    }

    @DeleteMapping("/deleteDoctor/{doctorRegNo}")
    public void deleteDoctor(@PathVariable String doctorRegNo) {
        doctorService.deleteDoctor(doctorRegNo);
    }
}