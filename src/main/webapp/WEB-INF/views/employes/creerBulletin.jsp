<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="/paie/mvc/employes/creer">Creer employé</a>
<a href="/paie/mvc/employes/lister">Lister employé</a>
<a href="/paie/mvc/bulletin/creer">Bulletin</a>

<h1>Créer Bulletin</h1>
<form:form method="post" modelAttribute="bulletin"
	action="/paie/mvc/bulletin/creer">
	<table>
	<tr>
			<td>prime exceptionnelle</td>
			<td><form:input type="number" path="primeExceptionnelle" /></td>
		</tr>
		<tr>
			<form:select path="remunerationEmploye.id">
				<c:forEach items="${emp}" var="e">
					<form:option value="${e.id}">${e.matricule}</form:option>
				</c:forEach>
			</form:select>
		</tr>
		<tr>
			<form:select path="periode.id">
				<c:forEach items="${per}" var="p">
					<form:option value="${p.id}">${p.dateDebut}-${p.dateFin}</form:option>
				</c:forEach>
			</form:select>
		</tr>
<input type="submit">
	</table>
</form:form>