<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="/paie/mvc/employes/creer">Creer employé</a>
<a href="/paie/mvc/employes/lister">Lister employé</a>
<a href="/paie/mvc/bulletin/creer">Bulletin</a>

<h1>Créer Employe</h1>
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