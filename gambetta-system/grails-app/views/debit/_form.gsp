<%@ page import="gambetta.system.Debit" %>

<g:javascript>
	function updatePrice(e){
		document.getElementById("price").value = e.responseText;
	}
</g:javascript>

<div class="fieldcontain ${hasErrors(bean: debitInstance, field: 'faultDescription', 'error')} ">
	<label for="faultDescription">
		<g:message code="debit.faultDescription.label" default="Fault Description" />

	</label>
	
	<g:select name="faultDescription" from="${gambetta.system.Fault.list()}"
		onchange="${remoteFunction(
            controller:'fault', 
            action:'getFaultValue', 
            params:'\'id=\' + this.value', 
            onComplete:'updatePrice(XMLHttpRequest)')}"
	   optionKey="id" optionValue="name" value="${debitInstance?.faultDescription}" noSelection="['':'-Choose The Fault-']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: debitInstance, field: 'workarounder', 'error')} required">
	<label for="workarounder">
		<g:message code="debit.workarounder.label" default="Workarounder" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="workarounder" name="workarounder.id" from="${gambetta.system.Workarounder.list()}" optionKey="id" required="" value="${debitInstance?.workarounder?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: debitInstance, field: 'occurred', 'error')} required">
	<label for="occurred">
		<g:message code="debit.occurred.label" default="Occurred" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="occurred" precision="day"  value="${debitInstance?.occurred}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: debitInstance, field: 'value', 'error')} required">
	<label for="value">
		<g:message code="debit.value.label" default="Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="value" min="0.5" required="" value="${fieldValue(bean: debitInstance, field: 'value')}" id="price" readonly="true"/>
</div>

