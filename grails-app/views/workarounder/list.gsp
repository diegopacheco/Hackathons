
<%@ page import="gambetta.system.Workarounder" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'workarounder.label', default: 'Workarounder')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-workarounder" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-workarounder" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:jasperReport controller="Workarounder" action="createReport" jasper="all-workarounder" format="PDF" name="Workarounders" />
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'workarounder.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'workarounder.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="totalDebits" title="${message(code: 'workarounder.totalDebits.label', default: 'Total Debits')}" />
					
						<g:sortableColumn property="currentdebits" title="${message(code: 'workarounder.currentdebits.label', default: 'Currentdebits')}" />
					
						<g:sortableColumn property="twitter" title="${message(code: 'workarounder.twitter.label', default: 'Twitter')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${workarounderInstanceList}" status="i" var="workarounderInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${workarounderInstance.id}">${fieldValue(bean: workarounderInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: workarounderInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: workarounderInstance, field: "totalDebits")}</td>
					
						<td>${fieldValue(bean: workarounderInstance, field: "currentdebits")}</td>
					
						<td>${fieldValue(bean: workarounderInstance, field: "twitter")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${workarounderInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
