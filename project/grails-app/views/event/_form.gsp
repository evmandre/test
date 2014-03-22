<%@ page import="grails.clickstart.Event" %>



<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="event.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="5000" value="${eventInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'category', 'error')} required">
	<label for="category">
		<g:message code="event.category.label" default="Category" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="category" name="category.id" from="${grails.clickstart.EventCategory.list()}" optionKey="id" required="" value="${eventInstance?.category?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'comments', 'error')} ">
	<label for="comments">
		<g:message code="event.comments.label" default="Comments" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${eventInstance?.comments?}" var="c">
    <li><g:link controller="eventComment" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="eventComment" action="create" params="['event.id': eventInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'eventComment.label', default: 'EventComment')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'contactInfo', 'error')} ">
	<label for="contactInfo">
		<g:message code="event.contactInfo.label" default="Contact Info" />
		
	</label>
	<g:textField name="contactInfo" value="${eventInstance?.contactInfo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'dateOfEvent', 'error')} required">
	<label for="dateOfEvent">
		<g:message code="event.dateOfEvent.label" default="Date Of Event" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateOfEvent" precision="day"  value="${eventInstance?.dateOfEvent}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'eventTitle', 'error')} ">
	<label for="eventTitle">
		<g:message code="event.eventTitle.label" default="Event Title" />
		
	</label>
	<g:textField name="eventTitle" value="${eventInstance?.eventTitle}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'fee', 'error')} required">
	<label for="fee">
		<g:message code="event.fee.label" default="Fee" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="fee" value="${fieldValue(bean: eventInstance, field: 'fee')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="event.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="type" name="type.id" from="${grails.clickstart.EventType.list()}" optionKey="id" required="" value="${eventInstance?.type?.id}" class="many-to-one"/>
</div>

