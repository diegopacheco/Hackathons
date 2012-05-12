
<%@ page import="gambetta.system.TweetAcountInformation" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tweetAcountInformation.label', default: 'TweetAcountInformation')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-tweetAcountInformation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-tweetAcountInformation" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list tweetAcountInformation">
			
				<g:if test="${tweetAcountInformationInstance?.oAuthConsumerKey}">
				<li class="fieldcontain">
					<span id="oAuthConsumerKey-label" class="property-label"><g:message code="tweetAcountInformation.oAuthConsumerKey.label" default="OA uth Consumer Key" /></span>
					
						<span class="property-value" aria-labelledby="oAuthConsumerKey-label"><g:fieldValue bean="${tweetAcountInformationInstance}" field="oAuthConsumerKey"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tweetAcountInformationInstance?.oAuthConsumerSecret}">
				<li class="fieldcontain">
					<span id="oAuthConsumerSecret-label" class="property-label"><g:message code="tweetAcountInformation.oAuthConsumerSecret.label" default="OA uth Consumer Secret" /></span>
					
						<span class="property-value" aria-labelledby="oAuthConsumerSecret-label"><g:fieldValue bean="${tweetAcountInformationInstance}" field="oAuthConsumerSecret"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tweetAcountInformationInstance?.oAuthAccessToken}">
				<li class="fieldcontain">
					<span id="oAuthAccessToken-label" class="property-label"><g:message code="tweetAcountInformation.oAuthAccessToken.label" default="OA uth Access Token" /></span>
					
						<span class="property-value" aria-labelledby="oAuthAccessToken-label"><g:fieldValue bean="${tweetAcountInformationInstance}" field="oAuthAccessToken"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tweetAcountInformationInstance?.oAuthAccessTokenSecret}">
				<li class="fieldcontain">
					<span id="oAuthAccessTokenSecret-label" class="property-label"><g:message code="tweetAcountInformation.oAuthAccessTokenSecret.label" default="OA uth Access Token Secret" /></span>
					
						<span class="property-value" aria-labelledby="oAuthAccessTokenSecret-label"><g:fieldValue bean="${tweetAcountInformationInstance}" field="oAuthAccessTokenSecret"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${tweetAcountInformationInstance?.id}" />
					<g:link class="edit" action="edit" id="${tweetAcountInformationInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
