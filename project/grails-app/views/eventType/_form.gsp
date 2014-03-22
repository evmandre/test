<%@ page import="grails.clickstart.EventType" %>



<div class="fieldcontain ${hasErrors(bean: eventTypeInstance, field: 'category', 'error')} required">
	<label for="category">
		<g:message code="eventType.category.label" default="Category" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="category" name="category.id" from="${grails.clickstart.EventCategory.list()}" optionKey="id" required="" value="${eventTypeInstance?.category?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventTypeInstance, field: 'typeofCategory', 'error')} ">
	<label for="typeofCategory">
		<g:message code="eventType.typeofCategory.label" default="Typeof Category" />
		
	</label>
	<g:textField name="typeofCategory" value="${eventTypeInstance?.typeofCategory}"/>
</div>

