<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Patient</title>
</head>
<body>
<form method="post" action="MainServlet">
<h2>View Patient Record</h2>
<input type="hidden" name="operation" value="viewRecord">
PATIENTNAME:<input type="text" name="patientName"><br><br>
ADMISSIONDATE:<input type="date" name="admissionDate"><br><br>
<input type="submit" value="Search" name="operation">
</form>
</body>
</html>