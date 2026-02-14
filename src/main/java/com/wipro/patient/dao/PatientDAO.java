package com.wipro.patient.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.wipro.patient.bean.PatientBean;
import com.wipro.patient.util.DBUtil;

public class PatientDAO {
	Connection con=DBUtil.getDBConnection();
	public String createRecord(PatientBean bean)
	{
		String query="insert into PATIENT_TBL values(?,?,?,?,?,?)";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, bean.getPatientId());
			ps.setString(2, bean.getPatientName());
			ps.setString(3, bean.getDisease());
			ps.setDate(4, new Date(bean.getAdmissionDate().getTime()));
			ps.setInt(5, bean.getAge());
			ps.setString(6, bean.getRemarks());
			int rs=ps.executeUpdate();
			if(rs>0)
			{
				return bean.getPatientId();
			}
			return "FAIL";
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return "INVALID";
		}
	}
	public PatientBean fetchRecord(String patientName, Date admissionDate)
	{
		String query="select * from PATIENT_TBL where PATIENTNAME=? AND ADMISSION_DATE=?";
		try 
		{
			PreparedStatement ps=con.prepareStatement(query);	
			ps.setString(1, patientName);
			ps.setDate(2, admissionDate);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				PatientBean patient=new PatientBean();
				patient.setPatientId(rs.getString(1));
				patient.setPatientName(rs.getString(2));
				patient.setDisease(rs.getString(3));
				patient.setAdmissionDate(rs.getDate(4));
				patient.setAge(rs.getInt(5));
				patient.setRemarks(rs.getString(6));
				return patient;
			}
			return null;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}	
	}
	public String generatePatientID(String patientName, Date admissionDate) 
	{
		String patientid=null;
		try
		{
			DateFormat f = new SimpleDateFormat("yyyyMMdd"); 
			String temp = f.format(admissionDate); 
			String name=patientName.substring(0,2).toUpperCase();
			String query="SELECT PATIENT_SEQ.NEXTVAL AS SEQ FROM dual";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				long seq=rs.getInt("seq");
				patientid=temp+name+seq;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return patientid;
	}
	public boolean recordExists(String patientName,Date admissionDate)
	{
		String query="select * from PATIENT_TBL where PATIENTNAME=? AND ADMISSION_DATE=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, patientName);
			ps.setDate(2, new Date(admissionDate.getTime()));
			ResultSet rs=ps.executeQuery();
			if (rs.next()) 
			{
                return true;
            }
			return false;

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public List<PatientBean> fetchAllRecords() 
	{
		List<PatientBean> list=new ArrayList<>();
		String query="select * from PATIENT_TBL";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				PatientBean patient=new PatientBean();
				patient.setPatientId(rs.getString(1));
				patient.setPatientName(rs.getString(2));
				patient.setDisease(rs.getString(3));
				patient.setAdmissionDate(rs.getDate(4));
				patient.setAge(rs.getInt(5));
				patient.setRemarks(rs.getString(6));
				list.add(patient);
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		return list;
	}
}
