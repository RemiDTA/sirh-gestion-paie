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
<body class="container">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/paie">Acceuil</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="/paie/mvc/employes/creer">Creer employé <span
						class="sr-only">cc</span></a></li>
				<li class="nav-item"><a class="nav-link"
					href="/paie/mvc/employes/lister">Lister employé</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/paie/mvc/bulletin/creer">Creer bulletin</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/paie/mvc/bulletin/lister">Lister bulletin</a></li>
			</ul>
		</div>
	</nav>

	<h1>Bulletin de salaire</h1>

	<div class="row mt-5">
		<h3 class="col-lg-7">Entreprise</h3>
		<h3 class="col-lg-5">Période</h3>
	</div>
	<div class="row">
		<div class="col-lg-7">${bulletin.remunerationEmploye.entreprise.denomination}</div>
		<div class="col-lg-5">Du ${bulletin.periode.dateDebut} Au
			${bulletin.periode.dateFin}</div>
	</div>
	<div class="row">
		<div class="col-lg-7">${bulletin.remunerationEmploye.entreprise.siret}</div>
		<div class="col-lg-5">${bulletin.remunerationEmploye.matricule}</div>
	</div>
	<br />
	<table class="table table-striped mt-5">
		<caption>Salaire</caption>
		<thead>
			<tr>
				<th scope="col">Rubriques</th>
				<th scope="col">Base</th>
				<th scope="col">Tx salarial</th>
				<th scope="col">Montant Salarial</th>
				<th scope="col">Tx Patronal</th>
				<th scope="col">Cot. Patronal</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="col">Salaire de base
				</td>
				<td scope="col">151.67</td>
				<td scope="col">11.0984</td>
				<td scope="col">1683.30</td>
				<td scope="col"></td>
				<td scope="col"></td>
			</tr>
			<tr>
				<th scope="col">Prime Exept.</th>
				<th scope="col"></th>
				<th scope="col"></th>
				<th scope="col">${bulletin.primeExceptionnelle}</th>
				<th scope="col"></th>
				<th scope="col"></th>
			</tr>
			<tr>
				<th scope="col">Salaire Brut</th>
				<th scope="col"></th>
				<th scope="col"></th>
				<th scope="col">${bulletin.primeExceptionnelle}+1683.30</th>
				<th scope="col"></th>
				<th scope="col"></th>
			</tr>
		</tbody>
	</table>
	<table class="table table-striped mt-5">
		<caption>Cotisations</caption>
		<thead>
			<tr>
				<th scope="col">Rubriques</th>
				<th scope="col">Base</th>
				<th scope="col">Tx salarial</th>
				<th scope="col">Montant Salarial</th>
				<th scope="col">Tx Patronal</th>
				<th scope="col">Cot. Patronal</th>
			</tr>
		</thead>
		<c:forEach
			items="${bulletin.remunerationEmploye.profilRemuneration.cotisationsNonImposables}"
			var="c">
			<tr>
				<td>${c.code}${c.libelle}</td>
				<td>xxx</td>
				<td>${c.tauxSalarial}</td>
				<td>xxx</td>
				<td>${c.tauxPatronal}</td>
				<td>xxx</td>
			</tr>
		</c:forEach>
		<tr>
			<th scope="col">Total retenue</th>
			<th scope="col">xxx</th>
			<th scope="col">xxx</th>
			<th scope="col">xxx</th>
			<th scope="col">xxx</th>
			<th scope="col">xxx</th>
		</tr>
	</table>
	<table class="table table-striped mt-5">
		<caption>Net imposable</caption>
		<thead>
			<tr>
				<th scope="col">Rubriques</th>
				<th scope="col">Base</th>
				<th scope="col">Tx salarial</th>
				<th scope="col">Montant Salarial</th>
				<th scope="col">Tx Patronal</th>
				<th scope="col">Cot. Patronal</th>
			</tr>
		</thead>
		<c:forEach
			items="${bulletin.remunerationEmploye.profilRemuneration.cotisationsImposables}"
			var="c">
			<tr>
				<td>${c.code}${c.libelle}</td>
				<td>xxx</td>
				<td>${c.tauxSalarial}</td>
				<td>xxx</td>
				<td>${c.tauxPatronal}</td>
				<td>xxx</td>
			</tr>
		</c:forEach>
		<tr>
			<th scope="col">Total retenue</th>
			<th scope="col">xxx</th>
			<th scope="col">xxx</th>
			<th scope="col">xxx</th>
			<th scope="col">xxx</th>
			<th scope="col">xxx</th>
		</tr>
	</table>
</body>
</html>