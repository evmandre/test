
<%@ page import="grails.clickstart.Event" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-event" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-event" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list event">
			
				<g:if test="${eventInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="event.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${eventInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.category}">
				<li class="fieldcontain">
					<span id="category-label" class="property-label"><g:message code="event.category.label" default="Category" /></span>
					
						<span class="property-value" aria-labelledby="category-label"><g:link controller="eventCategory" action="show" id="${eventInstance?.category?.id}">${eventInstance?.category?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.comments}">
				<li class="fieldcontain">
					<span id="comments-label" class="property-label"><g:message code="event.comments.label" default="Comments" /></span>
					
						<g:each in="${eventInstance.comments}" var="c">
						<span class="property-value" aria-labelledby="comments-label"><g:link controller="eventComment" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.contactInfo}">
				<li class="fieldcontain">
					<span id="contactInfo-label" class="property-label"><g:message code="event.contactInfo.label" default="Contact Info" /></span>
					
						<span class="property-value" aria-labelledby="contactInfo-label"><g:fieldValue bean="${eventInstance}" field="contactInfo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.dateOfEvent}">
				<li class="fieldcontain">
					<span id="dateOfEvent-label" class="property-label"><g:message code="event.dateOfEvent.label" default="Date Of Event" /></span>
					
						<span class="property-value" aria-labelledby="dateOfEvent-label"><g:formatDate date="${eventInstance?.dateOfEvent}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.eventTitle}">
				<li class="fieldcontain">
					<span id="eventTitle-label" class="property-label"><g:message code="event.eventTitle.label" default="Event Title" /></span>
					
						<span class="property-value" aria-labelledby="eventTitle-label"><g:fieldValue bean="${eventInstance}" field="eventTitle"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.fee}">
				<li class="fieldcontain">
					<span id="fee-label" class="property-label"><g:message code="event.fee.label" default="Fee" /></span>
					
						<span class="property-value" aria-labelledby="fee-label"><g:fieldValue bean="${eventInstance}" field="fee"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="property-label"><g:message code="event.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:link controller="eventType" action="show" id="${eventInstance?.type?.id}">${eventInstance?.type?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:eventInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${eventInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
