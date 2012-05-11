
<%@ page import="gambetta.system.Debit" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'debit.label', default: 'Debit')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-debit" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-debit" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="faultDescription" title="${message(code: 'debit.faultDescription.label', default: 'Fault Description')}" />
					
						<th><g:message code="debit.workarounder.label" default="Workarounder" /></th>
					
						<g:sortableColumn property="occurred" title="${message(code: 'debit.occurred.label', default: 'Occurred')}" />
					
						<g:sortableColumn property="value" title="${message(code: 'debit.value.label', default: 'Value')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${debitInstanceList}" status="i" var="debitInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${debitInstance.id}">${fieldValue(bean: debitInstance, field: "faultDescription")}</g:link></td>
					
						<td>${fieldValue(bean: debitInstance, field: "workarounder")}</td>
					
						<td><g:formatDate date="${debitInstance.occurred}" /></td>
					
						<td>${fieldValue(bean: debitInstance, field: "value")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${debitInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
