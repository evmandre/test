<%@ page import="grails.clickstart.EventCategory" %>



<div class="fieldcontain ${hasErrors(bean: eventCategoryInstance, field: 'categoryName', 'error')} ">
	<label for="categoryName">
		<g:message code="eventCategory.categoryName.label" default="Category Name" />
		
	</label>
	<g:textField name="categoryName" value="${eventCategoryInstance?.categoryName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventCategoryInstance, field: 'event', 'error')} ">
	<label for="event">
		<g:message code="eventCategory.event.label" default="Event" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${eventCategoryInstance?.event?}" var="e">
    <li><g:link controller="event" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="event" action="create" params="['eventCategory.id': eventCategoryInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'event.label', default: 'Event')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: eventCategoryInstance, field: 'type', 'error')} ">
	<label for="type">
		<g:message code="eventCategory.type.label" default="Type" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${eventCategoryInstance?.type?}" var="t">
    <li><g:link controller="eventType" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="eventType" action="create" params="['eventCategory.id': eventCategoryInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'eventType.label', default: 'EventType')])}</g:link>
</li>
</ul>

</div>

