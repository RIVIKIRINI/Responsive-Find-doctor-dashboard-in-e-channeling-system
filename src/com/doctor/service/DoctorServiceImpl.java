package com.doctor.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.doctor.model.Doctor;
import com.doctor.service.DoctorServiceImpl;
import com.doctor.util.CommonConstants;
import com.doctor.util.CommonUtil;
import com.doctor.util.DBConnection;
import com.doctor.util.QueryUtil;


public class DoctorServiceImpl implements IDoctorService{
	
	
	private static Connection connection;
	private static Statement stmt;
	private static PreparedStatement preparedStatement;
	
	static {
		
		createDoctorTable();
		
	}
	
	public static void createDoctorTable() {
		
		
		try {
			
			connection = DBConnection.getDBConnection();
			
			stmt = connection.createStatement();
			
			stmt.execute(QueryUtil.queryById(CommonConstants.QUERY_ID_CREATE_DOCTOR_TABLE));
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			System.out.println("Create Table Exception " +e.getMessage());
			
		}finally {
			
			try {
				
				if(connection != null) {
					connection.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	@Override
	public void addDoctor(Doctor doctor) {
		
		String doctorId = CommonUtil.generateDoctorIds(getDoctorIds());
		
		try {
			
			connection = DBConnection.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryById(CommonConstants.QUERY_ID_INSERT_DOCTOR));
			connection.setAutoCommit(false);
			
			doctor.setDoctorId(doctorId);
			
		
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE,doctor.getDoctorId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO,doctor.getFirstName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE,doctor.getLastName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR,doctor.getHospital());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE,doctor.getMobileNo());
	
			preparedStatement.executeLargeUpdate();
			connection.commit();
			
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}finally {
			
			try {
				
				if(connection != null) {
					connection.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public ArrayList<Doctor> getDoctors() {
		
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		
		try {
			connection = DBConnection.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryById(CommonConstants.QUERY_ID_GET_ALL_DOCTORS));
		
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				Doctor doc = new Doctor();
				
				doc.setDoctorId(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				doc.setFirstName(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				doc.setLastName(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
				doc.setHospital(rs.getString(CommonConstants.COLUMN_INDEX_FOUR));
				doc.setMobileNo(rs.getString(CommonConstants.COLUMN_INDEX_FIVE));
				
				doctorList.add(doc);
			}
			
	}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
		System.out.println(e.getMessage());
	}finally {
		
		try {
			
			if(connection != null) {
				connection.close();
			}
			if(preparedStatement != null) {
				preparedStatement.close();
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	  return doctorList;
}

	@Override
	public ArrayList<Doctor> getDoctorById(String doctorId) {
	
ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		
		try {
			connection = DBConnection.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryById(CommonConstants.QUERY_ID_GET_DOCTOR_BY_ID));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, doctorId);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				Doctor doc = new Doctor();
				
				doc.setDoctorId(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				doc.setFirstName(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				doc.setLastName(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
				doc.setHospital(rs.getString(CommonConstants.COLUMN_INDEX_FOUR));
				doc.setMobileNo(rs.getString(CommonConstants.COLUMN_INDEX_FIVE));
				
				doctorList.add(doc);
			}
			
	}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
		System.out.println(e.getMessage());
	}finally {
		
		try {
			
			if(connection != null) {
				connection.close();
			}
			if(preparedStatement != null) {
				preparedStatement.close();
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	  return doctorList;
}
		
	

	@Override
	public void updateDoctor(String doctorId, Doctor doctor) {
		// TODO Auto-generated method stub
		
		try {
			
			connection = DBConnection.getDBConnection();
			
			System.out.println("from insite try at update doctor method "+ doctorId);
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryById(CommonConstants.QUERY_ID_UPDATE_DOCTOR));
			connection.setAutoCommit(false);
			
		
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE,doctor.getFirstName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO,doctor.getLastName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE,doctor.getHospital());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR,doctor.getMobileNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE,doctor.getDoctorId());
	
			preparedStatement.executeLargeUpdate();
			connection.commit();
			
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}finally {
			
			try {
				
				if(connection != null) {
					connection.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}

	@Override
	public void deleteDoctor(String doctorId) {
		
		if(doctorId != null && !doctorId.isEmpty()) {
			
		 try {
			connection = DBConnection.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryById(CommonConstants.QUERY_ID_DELETE_DOCTOR));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, doctorId);
			
			preparedStatement.execute();
			
		 }catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			 System.out.println(e.getMessage());
		}finally {
			
			try {
				
				if(connection != null) {
					connection.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		  }
		 
		}
		
	}
    
	public ArrayList<String> getDoctorIds(){
		
		ArrayList<String> ids = new ArrayList<String>();
		
		try {
			connection = DBConnection.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryById(CommonConstants.QUERY_ID_GET_DOCTOR_IDS));
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				ids.add(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
			
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}finally {
			
			try {
				if(connection != null) {
					connection.close();
				}
				if(preparedStatement != null){
					preparedStatement.close();
				}
				
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return ids;
	}
}


