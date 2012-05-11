
<%@ page import="gambetta.system.TweetAcountInformation" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tweetAcountInformation.label', default: 'TweetAcountInformation')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-tweetAcountInformation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-tweetAcountInformation" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="oAuthConsumerKey" title="${message(code: 'tweetAcountInformation.oAuthConsumerKey.label', default: 'OA uth Consumer Key')}" />
					
						<g:sortableColumn property="oAuthConsumerSecret" title="${message(code: 'tweetAcountInformation.oAuthConsumerSecret.label', default: 'OA uth Consumer Secret')}" />
					
						<g:sortableColumn property="oAuthAccessToken" title="${message(code: 'tweetAcountInformation.oAuthAccessToken.label', default: 'OA uth Access Token')}" />
					
						<g:sortableColumn property="oAuthAccessTokenSecret" title="${message(code: 'tweetAcountInformation.oAuthAccessTokenSecret.label', default: 'OA uth Access Token Secret')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${tweetAcountInformationInstanceList}" status="i" var="tweetAcountInformationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${tweetAcountInformationInstance.id}">${fieldValue(bean: tweetAcountInformationInstance, field: "oAuthConsumerKey")}</g:link></td>
					
						<td>${fieldValue(bean: tweetAcountInformationInstance, field: "oAuthConsumerSecret")}</td>
					
						<td>${fieldValue(bean: tweetAcountInformationInstance, field: "oAuthAccessToken")}</td>
					
						<td>${fieldValue(bean: tweetAcountInformationInstance, field: "oAuthAccessTokenSecret")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${tweetAcountInformationInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
