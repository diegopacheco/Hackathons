
<%@ page import="gambetta.system.Tweet" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tweet.label', default: 'Tweet')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-tweet" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-tweet" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list tweet">
			
				<g:if test="${tweetInstance?.pin}">
				<li class="fieldcontain">
					<span id="pin-label" class="property-label"><g:message code="tweet.pin.label" default="Pin" /></span>
					
						<span class="property-value" aria-labelledby="pin-label"><g:fieldValue bean="${tweetInstance}" field="pin"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tweetInstance?.msg}">
				<li class="fieldcontain">
					<span id="msg-label" class="property-label"><g:message code="tweet.msg.label" default="Msg" /></span>
					
						<span class="property-value" aria-labelledby="msg-label"><g:fieldValue bean="${tweetInstance}" field="msg"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${tweetInstance?.id}" />
					<g:link class="edit" action="edit" id="${tweetInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
