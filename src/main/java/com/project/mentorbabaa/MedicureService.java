package com.project.mentorbabaa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicureService {
    
    @Autowired
    MedicureRepository doctorRepository;
    
    // Method to register a new doctor
    public Doctor registerDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Method to create a dummy doctor for testing
    public Doctor createDoctor() {
        // Implement your logic for creating a new doctor
        Doctor doctor = new Doctor("MP1110","Shubham","Neurologist","15 Years");
        // Set doctor details
        return doctorRepository.save(doctor);
    }

    // Method to get details of a doctor by registration ID
    public Doctor getDoctorDetails(String doctorRegistrationId) {
        return doctorRepository.findById(doctorRegistrationId).orElse(null);
    }
    
    // Method to create a dummy doctor without saving to repository
    public Doctor registerDummyDoctor() {
        Doctor doctor = new Doctor("MP1110","Shubham","Neurologist","15 Years");
        return doctor;
    }
    
    // Method to search doctors by name
    public List<Doctor> searchDoctor(String doctorName) {
        return doctorRepository.findByDoctorNameIgnoreCase(doctorName);
    }

    // Method to update a doctor's details
    public Doctor updateDoctor(String doctorRegNo, Doctor doctor) {
        // Find the doctor by registration number
        Doctor existingDoctor = doctorRepository.findById(doctorRegNo).orElse(null);
        if (existingDoctor != null) {
            // Update the doctor's details
            existingDoctor.setDoctorName(doctor.getDoctorName());
            existingDoctor.setDoctorSpeciality(doctor.getDoctorSpeciality());
            existingDoctor.setDoctorExperience(doctor.getDoctorExperience());
            // Save the updated doctor to the repository
            return doctorRepository.save(existingDoctor);
        }
        return null; // Return null if doctor with given registration number is not found
    }

    // Method to delete a doctor by registration number
    public void deleteDoctor(String doctorRegNo) {
        doctorRepository.deleteById(doctorRegNo);
    }

    // Method to return a greeting message
    public String sayHello() {
        return "Hello from Doctor Shubham";
    }
}
