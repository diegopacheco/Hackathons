<!doctype html>
<html>
<head>
<meta name="layout" content="main" />
<title>Welcome to Grails</title>
<style type="text/css" media="screen">
#status {
	background-color: #eee;
	border: .2em solid #fff;
	margin: 2em 2em 1em;
	padding: 1em;
	width: 12em;
	float: left;
	-moz-box-shadow: 0px 0px 1.25em #ccc;
	-webkit-box-shadow: 0px 0px 1.25em #ccc;
	box-shadow: 0px 0px 1.25em #ccc;
	-moz-border-radius: 0.6em;
	-webkit-border-radius: 0.6em;
	border-radius: 0.6em;
}

.ie6 #status {
	display: inline;
	/* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
}

#status ul {
	font-size: 0.9em;
	list-style-type: none;
	margin-bottom: 0.6em;
	padding: 0;
}

#status h1 {
	text-transform: uppercase;
	font-size: 1.1em;
	margin: 0 0 0.3em;
}

#page-body {
	margin: 2em 1em 1.25em 18em;
	float: left;
}

#page-margin {
	margin: 2em 1em 1.25em 4em;
	float: left;
}

.grid_container {
	padding-left: 3em;
	padding-right: 3em;
}

.grids {
	overflow: hidden;
}

.g1of2 {
	width: 50%;
}

.g1of2,.g1of3,.g1of4,.g1of5,.g2of3,.g2of5,.g3of4,.g3of5,.g4of5 {
	float: left;
}

h2 {
	margin-top: 1em;
	margin-bottom: 0.3em;
	font-size: 1em;
}

p {
	margin: 0.25em 0;
}

#controller-list ul {
	list-style-position: inside;
}

#controller-list li {
	list-style-position: inside;
	margin: 0.25em 0;
}

@media screen and (max-width: 480px) {
	#status {
		display: none;
	}
	#page-body {
		margin: 0 1em 1em;
	}
	#page-body h1 {
		margin-top: 0;
	}
}
</style>
</head>
<body>
	<a href="#page-body" class="skip"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>

	<div class="grid_container">
		<div class="grids">
			<div class="g1of2">
				<div id="controller-list" role="navigation">
					<h2>Available Controllers:</h2>
					<ul>
						<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
							<li class="controller">
								<g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
							</li>
						</g:each>
					</ul>
				</div>
			</div>
			<div class="g1of2">

		<h1>Welcome to Gambettinha system</h1>
		<p>Discipline rules!!</p>
		<h2>Worarounders</h2>
		<table>
			<thead>
				<tr>

					<g:sortableColumn property="name"
						title="${message(code: 'workarounder.name.label', default: 'Name')}" />

					<g:sortableColumn property="currentdebits"
						title="${message(code: 'workarounder.currentdebits.label', default: 'Currentdebits')}" />

					<g:sortableColumn property="totalDebits"
						title="${message(code: 'workarounder.totalDebits.label', default: 'Total Debits')}" />
				</tr>
			</thead>
			<g:each in="${workarounders}" status="i" var="workarounderInstance">
				<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

					<td><g:link controller="Workarounder" action="show"
							id="${workarounderInstance.id}">
							${fieldValue(bean: workarounderInstance, field: "name")}
						</g:link></td>
					<td>
						${fieldValue(bean: workarounderInstance, field: "currentdebits")}
					</td>

					<td><g:link controller="Debit" action="list"
							params="[debitInstanceList: workarounderInstance.debits]">
							${fieldValue(bean: workarounderInstance, field: "totalDebits")}
						</g:link></td>
				</tr>
			</g:each>
		</table>


			</div>
		</div>
	</div>
</body>
</html>
