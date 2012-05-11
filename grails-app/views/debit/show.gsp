
<%@ page import="gambetta.system.Debit" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'debit.label', default: 'Debit')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-debit" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-debit" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list debit">
			
				<g:if test="${debitInstance?.faultDescription}">
				<li class="fieldcontain">
					<span id="faultDescription-label" class="property-label"><g:message code="debit.faultDescription.label" default="Fault Description" /></span>
					
						<span class="property-value" aria-labelledby="faultDescription-label"><g:fieldValue bean="${debitInstance}" field="faultDescription"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${debitInstance?.workarounder}">
				<li class="fieldcontain">
					<span id="workarounder-label" class="property-label"><g:message code="debit.workarounder.label" default="Workarounder" /></span>
					
						<span class="property-value" aria-labelledby="workarounder-label"><g:link controller="workarounder" action="show" id="${debitInstance?.workarounder?.id}">${debitInstance?.workarounder?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${debitInstance?.occurred}">
				<li class="fieldcontain">
					<span id="occurred-label" class="property-label"><g:message code="debit.occurred.label" default="Occurred" /></span>
					
						<span class="property-value" aria-labelledby="occurred-label"><g:formatDate date="${debitInstance?.occurred}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${debitInstance?.value}">
				<li class="fieldcontain">
					<span id="value-label" class="property-label"><g:message code="debit.value.label" default="Value" /></span>
					
						<span class="property-value" aria-labelledby="value-label"><g:fieldValue bean="${debitInstance}" field="value"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${debitInstance?.id}" />
					<g:link class="edit" action="edit" id="${debitInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
