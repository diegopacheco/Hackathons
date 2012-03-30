<%@ page import="gambetta.system.Workarounder" %>



<div class="fieldcontain ${hasErrors(bean: workarounderInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="workarounder.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${workarounderInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: workarounderInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="workarounder.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${workarounderInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: workarounderInstance, field: 'totalDebits', 'error')} required">
	<label for="totalDebits">
		<g:message code="workarounder.totalDebits.label" default="Total Debits" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="totalDebits" min="0.1" required="" value="${fieldValue(bean: workarounderInstance, field: 'totalDebits')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: workarounderInstance, field: 'currentdebits', 'error')} required">
	<label for="currentdebits">
		<g:message code="workarounder.currentdebits.label" default="Currentdebits" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="currentdebits" min="0.1" required="" value="${fieldValue(bean: workarounderInstance, field: 'currentdebits')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: workarounderInstance, field: 'twitter', 'error')} ">
	<label for="twitter">
		<g:message code="workarounder.twitter.label" default="Twitter" />
		
	</label>
	<g:textField name="twitter" value="${workarounderInstance?.twitter}"/>
</div>

