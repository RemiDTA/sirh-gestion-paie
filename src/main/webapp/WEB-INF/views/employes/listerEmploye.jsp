<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<DOCTYPE html>
<html lang="en">

<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/css.css" />
<script src="https://code.jquery.com/jquery-1.12.3.js"></script>
<script src="<%=request.getContextPath()%>/js/ajoutCollaborateur.js"></script>
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
<body>
	<a href="/paie/mvc/employes/creer">Creer employÃ©</a>
	<a href="/paie/mvc/employes/lister">Lister employÃ©</a>
	<a href="/paie/mvc/bulletin/creer">Bulletin</a>
	<h1>Liste des employés</h1>

	<table>
		<tr>
			<th>Date de création</th>
			<th>Matricule</th>
			<th>Grade</th>
			<th>Entreprise</th>
		</tr>
		<c:forEach items="${emp}" var="employes">
			
		<tr>
			<td>${employes.dateCreation}</td>
			<td>${employes.matricule}</td>
			<td>${employes.grade.code}</td>
			<td>${employes.entreprise.denomination}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>