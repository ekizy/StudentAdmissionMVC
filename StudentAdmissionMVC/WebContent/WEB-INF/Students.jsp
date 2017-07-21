<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:genericpage>
<jsp:attribute name="header">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.admission" /></title>



</jsp:attribute>


<jsp:body>
  	 <div style="height:80px;">
  	 </div>

  	 <p align="center"> This page shows all of the students in the university. </p>

<div class="main">
<a  href="/StudentAdmissionMVC/getAdmission" class="btn btn-success" role="button">Add a Student</a>
</div>


<div class="main">

	<table>
	  	 <c:forEach items="${students}" var="student">
<p align="center">  ${student.studentName }   ${student.studentNumber } </p>
</c:forEach>
	</table>
</div>




</jsp:body>
</t:genericpage>