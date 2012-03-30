
<%@ page import="gambetta.system.Workarounder" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'workarounder.label', default: 'Workarounder')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-workarounder" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-workarounder" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list workarounder">
			
				<g:if test="${workarounderInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="workarounder.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${workarounderInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${workarounderInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="workarounder.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${workarounderInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${workarounderInstance?.totalDebits}">
				<li class="fieldcontain">
					<span id="totalDebits-label" class="property-label"><g:message code="workarounder.totalDebits.label" default="Total Debits" /></span>
					
						<span class="property-value" aria-labelledby="totalDebits-label"><g:fieldValue bean="${workarounderInstance}" field="totalDebits"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${workarounderInstance?.currentdebits}">
				<li class="fieldcontain">
					<span id="currentdebits-label" class="property-label"><g:message code="workarounder.currentdebits.label" default="Currentdebits" /></span>
					
						<span class="property-value" aria-labelledby="currentdebits-label"><g:fieldValue bean="${workarounderInstance}" field="currentdebits"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${workarounderInstance?.twitter}">
				<li class="fieldcontain">
					<span id="twitter-label" class="property-label"><g:message code="workarounder.twitter.label" default="Twitter" /></span>
					
						<span class="property-value" aria-labelledby="twitter-label"><g:fieldValue bean="${workarounderInstance}" field="twitter"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${workarounderInstance?.id}" />
					<g:link class="edit" action="edit" id="${workarounderInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
