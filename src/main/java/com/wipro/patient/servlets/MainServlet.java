package com.wipro.patient.servlets;

import java.io.IOException;

import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.patient.bean.PatientBean;
import com.wipro.patient.service.Administrator;
import com.wipro.patient.util.InvalidInputException;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String operation=request.getParameter("operation");
		try
		{
			if(operation.equals("newRecord"))
			{
				String result=addRecord(request);
				if(result.equals("SUCCESS"))
				{
					RequestDispatcher rd = request.getRequestDispatcher("success.html");
					rd.forward(request, response);
				}
				else if(result.equals("FAIL"))
				{
					RequestDispatcher rd = request.getRequestDispatcher("error.html");
					rd.forward(request, response);
				}
				else if(result.equals("FAIL") || 
				   result.equals("INVALID INPUT") ||
				   result.equals("INVALID PATIENT NAME") ||
				   result.equals("INVALID DISEASE") ||
				   result.equals("INVALID AGE") ||
				   result.equals("ALREADY EXISTS"))
				{
					RequestDispatcher rd = request.getRequestDispatcher("error.html");
					rd.forward(request, response);
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("success.html");
					rd.forward(request, response);
				}

			}
			else if(operation.equals("viewRecord"))
			{
				PatientBean patient =viewRecord(request);
	            request.setAttribute("patient", patient);
	            RequestDispatcher rd = request.getRequestDispatcher("displayPatient.jsp");
	            rd.forward(request, response);
			}
			else if(operation.equals("viewAllRecords"))
			{
				List<PatientBean> patients =viewAllRecords(request);
	            request.setAttribute("patients", patients);
	            RequestDispatcher rd = request.getRequestDispatcher("displayAllPatients.jsp");
	            rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("error.html");
				rd.forward(request, response);
			}
		}
		catch(InvalidInputException e)
		{
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response);
		}
		
	}
	public String addRecord(HttpServletRequest request) throws InvalidInputException {
	    String patientName = request.getParameter("patientName");
	    String disease = request.getParameter("disease");
	    String admissionDateStr = request.getParameter("admissionDate");
	    String age = request.getParameter("age");
	    String remarks = request.getParameter("remarks");		
	    PatientBean patient = new PatientBean();
	    patient.setPatientName(patientName);
	    patient.setDisease(disease);
	    try {
	        java.util.Date utilDate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(admissionDateStr);
	        patient.setAdmissionDate(new java.sql.Date(utilDate.getTime()));
	    } 
	    catch (java.text.ParseException e) 
	    {
	        throw new InvalidInputException();
	    }
	    patient.setAge(Integer.parseInt(age));
	    patient.setRemarks(remarks);

	    String result = new Administrator().addRecord(patient);
	    return result;
	}
	public PatientBean viewRecord(HttpServletRequest request) 
	{
		String patientName = request.getParameter("patientName");
        String admissionDate1= request.getParameter("admissionDate");
        Date admissionDate = Date.valueOf(admissionDate1);
        PatientBean patient = new Administrator().viewRecord(patientName,admissionDate);
        return patient;
	}
	public List<PatientBean> viewAllRecords(HttpServletRequest request) 
	{
		List<PatientBean> patients = new Administrator().viewAllRecords();
        return patients;
	}
}
