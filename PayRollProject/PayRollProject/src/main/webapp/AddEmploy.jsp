<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddEmploy.jsp" method="get">
  Employ number:
  <input type="number" name="empno" /><br/><br/>
  Employ name:
  <input type="text" name="name" /><br/><br/>
  Gender:
  <input type="radio" name="gender" value="MALE" />Male
  <input type="radio" name="gender" value="FEMALE" />Female
  <br/><br/>
  Salary:
  <input type="text" name="salary" /><br/><br/>
  <input type="submit" name="Add"/><br/><br/>

</form>
<c:if test="${param.empno != null }">
    <jsp:useBean id="emp" class="infinite.payroll.Employ"  />
    <jsp:setProperty property="*" name="emp"/>
    <jsp:useBean id="dao" class="infinite.payroll.EmployDAO" />
    <c:out value="${dao.addEmploy(emp)}" />
</c:if>
</body>
</html>