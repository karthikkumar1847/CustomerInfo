<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>person page</title>
</head>
<body>
<h2>Process Personal Info</h2>
<%@include file="/jsp/error.jsp" %>
<form:form modelAttribute="cinfo" method="post" action="person.go" >

	<table>
		<tr>
			<td><form:label path="firstName">First Name:</form:label>
			<td><form:input path="firstName"/>
			
		<tr>
			<td><form:label path="lastName">Last Name:</form:label>
			<td><form:input path="lastName"/>
			
		<tr>
			<td><form:label path="middleName">Middle Name:</form:label>
			<td><form:input path="middleName"/>
		<tr>
			<td><form:label path="gender">Gender:</form:label>
			<td><form:radiobutton path="gender" value="M"/>Male
			<form:radiobutton path="gender" value="F"/>Female
		<tr>
			<td colspan="2"><input type="submit" value="Submit" /></td>
	</table>	
</form:form>
</body>
</html>