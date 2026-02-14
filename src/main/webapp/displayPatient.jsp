	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<%@ page import="com.wipro.patient.bean.PatientBean" %>
	<%@ page import="java.sql.Date" %>
	<%@ page import="java.text.SimpleDateFormat" %>
	    
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Display Patient</title>
	</head>
	<body>
	
	<%
		PatientBean patient=(PatientBean) request.getAttribute("patient");
		if(patient != null)
		{
	%>
	<table border="1">
		<tr><td>ID</td><td><%= patient.getPatientId() %></td></tr>
	    <tr><td>Name</td><td><%= patient.getPatientName() %></td></tr>
	    <tr><td>Disease</td><td><%= patient.getDisease() %></td></tr>
	    <tr><td>Admission Date</td><td><%= new java.text.SimpleDateFormat("dd-MM-yyyy").format(patient.getAdmissionDate()) %>
	</td></tr>
	    <tr><td>Age</td><td><%= patient.getAge() %></td></tr>
	    <tr><td>Remarks</td><td><%=patient.getRemarks() %></td></tr>
	</table>
	<%
		}
		else
		{
	%>
		<p>"No matching records exists! Please try again!"</p>
	<%
		}
	%>
	</body>
	</html>