<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank page</title>
</head>
<body>

<h2>Process Bank Info</h2>
<%@include file="/jsp/error.jsp" %>
<form:form modelAttribute="cinfo" method="post" action="bank.go">
	<table>
		<tr>
			<td><form:label path="bankName">Bank Name: </form:label>
			<td><form:input path="bankName"/>
		<tr>
			<td><form:label path="accountNumber">Account Number: </form:label>
			<td><form:input path="accountNumber"/>
		<tr>
			<td><form:label path="ssn">SSN: </form:label>
			<td><form:input path="ssn"/>
		<tr>
			<td colspan="2"><input type="submit" value="Submit" /></td>
		
	</table>
</form:form>
</body>
</html>