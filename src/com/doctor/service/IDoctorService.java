package com.doctor.service;

import java.util.ArrayList;

import com.doctor.model.Doctor;

public interface IDoctorService {

		public void addDoctor(Doctor doctor);
		
		public ArrayList<Doctor> getDoctors();
		
		public ArrayList<Doctor> getDoctorById(String doctorId);
		
		public void updateDoctor(String doctorId,Doctor doctor);
		
		public void deleteDoctor(String doctorId);
		
		
}