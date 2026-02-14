<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Patient</title>
</head>
<body>
<form method="post" action="MainServlet">
<h2>Add Patient Record</h2>
  <input type="hidden" name="operation" value="newRecord">
	PATIENTNAME:<input type="text" name="patientName"><br><br>
	DISEASE:<input type="text" name="disease"><br><br>
	ADMISSIONDATE:<input type="date" name="admissionDate" ><br><br>
	AGE:<input type="number" name="age"><br><br>
	REMARKS:<input type="text" name="remarks"><br><br>
	<input type="submit" value="AddRecord">
</form>
</body>
</html>