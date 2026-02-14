package com.wipro.patient.service;

import java.sql.Date;
import java.util.List;

import com.wipro.patient.bean.PatientBean;
import com.wipro.patient.dao.PatientDAO;

public class Administrator {
	PatientDAO valid=new PatientDAO();
	public String addRecord(PatientBean bean)
	{
	    if(bean == null)
	    {
	        return "INVALID INPUT";
	    }
	    if(bean.getPatientName() == null || 
	       bean.getDisease() == null || 
	       bean.getAdmissionDate() == null)
	    {
	        return "INVALID INPUT";
	    }
	    if(bean.getPatientName().length() < 2)
	    {
	        return "INVALID PATIENT NAME";
	    }
	    if(bean.getDisease().length() < 2)
	    {
	        return "INVALID DISEASE";
	    }
	    if(bean.getAge() <= 0)
	    {
	        return "INVALID AGE";
	    }
	    if(valid.recordExists(bean.getPatientName(), new java.sql.Date(bean.getAdmissionDate().getTime())))
	    {
	        return "ALREADY EXISTS";
	    }
	    String id = valid.generatePatientID(bean.getPatientName(), new java.sql.Date(bean.getAdmissionDate().getTime()));
	    bean.setPatientId(id);
	    String result = valid.createRecord(bean);
	    if(result.equals("FAIL")) {
	        return "FAIL";
	    }
	    return result;  
	}

	public PatientBean viewRecord(String patientName, Date admissionDate) 
	{
		return valid.fetchRecord(patientName,admissionDate);
		
	}
	public List<PatientBean> viewAllRecords() 
	{
		return valid.fetchAllRecords();
	}
}
