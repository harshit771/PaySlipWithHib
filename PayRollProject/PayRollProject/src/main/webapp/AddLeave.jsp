<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddLeave.jsp" method="get">
Leave Id:
<input type="number" name="leaveId" /><br/><br/>
Employ Number:
<input type="number" name="empno" /><br/><br/>
Leave Start Date:
<input type="date" name="leaveStartDate" /><br/><br/>
Leave End Date:
<input type="date" name="leaveEndDate" /><br/><br/>
Reason:
<input type="text" name="leaveReason"/><br/><br/>
<input type="submit" value="Add" />

</form>
<c:if test="${param.empno != null && param.leaveStartDate != null}">
<jsp:useBean id="leave" class="infinite.payroll.LeaveDetails" />
<jsp:useBean id="dao" class="infinite.payroll.LeaveDetailsDAO" />
<jsp:setProperty property="leaveId" name="leave"/>
<jsp:setProperty property="empno" name="leave"/>
  <fmt:parseDate value="${param.leaveStartDate}" pattern="yyyy-MM-dd" var="sdate" />
	<c:set var="sqlDate1" value="${dao.convertDate(sdate)}" />
	
	<fmt:parseDate value="${param.leaveEndDate}" pattern="yyyy-MM-dd" var="edate" />
	<c:set var="sqlDate2" value="${dao.convertDate(edate)}" />
	
	<jsp:setProperty property="leaveStartDate" name="leave" value="${sqlDate1}"/>
	
	<jsp:setProperty property="leaveEndDate" name="leave" value="${sqlDate2}"/>
	<jsp:setProperty property="leaveReason" name="leave"/>
	
	
	<c:out value="${dao.addLeave(leave)}" />
</c:if>
</body>
</html>