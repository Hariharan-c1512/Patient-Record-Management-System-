<%@page import="java.awt.Paint"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.wipro.patient.bean.PatientBean" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display ALL Patient</title>
</head>
<body>
<%
	List<PatientBean> patients =(List<PatientBean>) request.getAttribute("patients");
	if(patients!=null && !patients.isEmpty()){
%>
	<h2>All Patient Records</h2>
    <table border="1">
        <tr>
            <th>ID</th><th>Name</th><th>Disease</th><th>Admission Date</th><th>Age</th><th>Remarks</th>
        </tr>
<%
	for(PatientBean p:patients){
%>
 	<tr>
        <td><%= p.getPatientId() %></td>
        <td><%= p.getPatientName() %></td>
        <td><%= p.getDisease() %></td>
        <td><%= p.getAdmissionDate() %></td>
        <td><%= p.getAge() %></td>
        <td><%= p.getRemarks() %></td>
    </tr>
<%
	}
%>
</table>
<%
	}else {
%>
<p>No Records Available</p>
<%
}
%>
</body>
</html>