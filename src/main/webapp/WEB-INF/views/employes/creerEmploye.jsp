<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<DOCTYPE html>
<html lang="en">

<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Paie</title>
</head>
<body class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/paie">Acceuil</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="/paie/mvc/employes/creer">Creer employ� <span class="sr-only">cc</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/paie/mvc/employes/lister">Lister employ�</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/paie/mvc/bulletin/creer">Creer bulletin</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/paie/mvc/bulletin/lister">Lister bulletin</a>
        </li>
        </ul>
    </div>
</nav>
	
<h1>Cr�er Employe</h1>
<form:form method="post" modelAttribute="remunerationEmploye"
	action="/paie/mvc/employes/creer">
	<table>
		<tr>
			<td>Matricule</td>
			<td><form:input path="matricule" /></td>
		</tr>
		<tr>
			<form:select path="entreprise.id">
				<c:forEach items="${ent}" var="e">
					<form:option value="${e.id}">${e.denomination}</form:option>
				</c:forEach>
			</form:select>
		</tr>
		<tr>
			<form:select path="profilRemuneration.id">
				<c:forEach items="${prof}" var="p">
					<form:option value="${p.id}">${p.code}</form:option>
				</c:forEach>
			</form:select>
		</tr>
		<tr>
			<form:select path="grade.id">
				<c:forEach items="${grade}" var="g">
					<form:option value="${g.id}">${g.code}</form:option>
				</c:forEach>
			</form:select>
		</tr>
<input type="submit">
	</table>
</form:form>