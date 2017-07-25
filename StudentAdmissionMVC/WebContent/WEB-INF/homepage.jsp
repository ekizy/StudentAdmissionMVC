 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
<jsp:attribute name="header">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.home" /></title>


</jsp:attribute>


<jsp:body>
  	 <div style="height:52px;">
  	 </div>

  	 <h1><spring:message code="label.welcome" /></h1>

  	 <h3><spring:message code="label.homeMessage" /></h3>




</jsp:body>
</t:genericpage>