<%@ page import="gambetta.system.TweetAcountInformation" %>



<div class="fieldcontain ${hasErrors(bean: tweetAcountInformationInstance, field: 'oAuthConsumerKey', 'error')} required">
	<label for="oAuthConsumerKey">
		<g:message code="tweetAcountInformation.oAuthConsumerKey.label" default="OA uth Consumer Key" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="oAuthConsumerKey" required="" value="${tweetAcountInformationInstance?.oAuthConsumerKey}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tweetAcountInformationInstance, field: 'oAuthConsumerSecret', 'error')} required">
	<label for="oAuthConsumerSecret">
		<g:message code="tweetAcountInformation.oAuthConsumerSecret.label" default="OA uth Consumer Secret" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="oAuthConsumerSecret" required="" value="${tweetAcountInformationInstance?.oAuthConsumerSecret}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tweetAcountInformationInstance, field: 'oAuthAccessToken', 'error')} required">
	<label for="oAuthAccessToken">
		<g:message code="tweetAcountInformation.oAuthAccessToken.label" default="OA uth Access Token" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="oAuthAccessToken" required="" value="${tweetAcountInformationInstance?.oAuthAccessToken}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tweetAcountInformationInstance, field: 'oAuthAccessTokenSecret', 'error')} required">
	<label for="oAuthAccessTokenSecret">
		<g:message code="tweetAcountInformation.oAuthAccessTokenSecret.label" default="OA uth Access Token Secret" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="oAuthAccessTokenSecret" required="" value="${tweetAcountInformationInstance?.oAuthAccessTokenSecret}"/>
</div>

