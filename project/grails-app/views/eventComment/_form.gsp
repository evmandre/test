<%@ page import="grails.clickstart.EventComment" %>



<div class="fieldcontain ${hasErrors(bean: eventCommentInstance, field: 'comment', 'error')} ">
	<label for="comment">
		<g:message code="eventComment.comment.label" default="Comment" />
		
	</label>
	<g:textField name="comment" value="${eventCommentInstance?.comment}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventCommentInstance, field: 'event', 'error')} required">
	<label for="event">
		<g:message code="eventComment.event.label" default="Event" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="event" name="event.id" from="${grails.clickstart.Event.list()}" optionKey="id" required="" value="${eventCommentInstance?.event?.id}" class="many-to-one"/>
</div>

