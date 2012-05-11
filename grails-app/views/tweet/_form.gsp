<%@ page import="gambetta.system.Tweet" %>



<div class="fieldcontain ${hasErrors(bean: tweetInstance, field: 'pin', 'error')} required">
	<label for="pin">
		<g:message code="tweet.pin.label" default="Pin" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="pin" required="" value="${tweetInstance?.pin}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tweetInstance, field: 'msg', 'error')} required">
	<label for="msg">
		<g:message code="tweet.msg.label" default="Msg" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="msg" required="" value="${tweetInstance?.msg}"/>
</div>

