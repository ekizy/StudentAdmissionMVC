<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

		<link href="./resources/bootstrap.css" rel="stylesheet"
			type="text/css">
		<link href="./resources/style.css" rel="stylesheet"
			type="text/css">

<html>

<body style="background-color: #DDDDDD">
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a  href="/StudentAdmissionMVC"><spring:message code="label.home" /></a></li>
					<li><a href="/StudentAdmissionMVC/students"><spring:message code="label.students" /></a></li>
					<li><a href="/StudentAdmissionMVC/teachers"><spring:message code="label.teachers" /></a></li>
					<li><a  href="/StudentAdmissionMVC/getAdmission.html">
					<spring:message code="label.studentAdmission" /></a></li>
					<li><a href="/StudentAdmissionMVC/contact"><spring:message code="label.contact" /></a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">

					<li><a
						href="?siteLanguage=en"
						style="text-decoration: none;"> English</a></li>
					<li><a
						href="?siteLanguage=de"
						style="text-decoration: none;">Deutsch</a></li>
					<li><a
						href="?siteLanguage=tr"
						style="text-decoration: none;">Türkçe</a></li>
				</ul>

			</div>


		</div>
	</div>
	<div id="pageheader">

		<jsp:invoke fragment="header" />
	</div>

	<div id="body">
		<jsp:doBody />
	</div>
	<div id="pagefooter">
		<jsp:invoke fragment="footer" />
	</div>
</body>
</html>