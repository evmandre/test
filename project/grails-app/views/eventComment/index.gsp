
<%@ page import="grails.clickstart.EventComment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'eventComment.label', default: 'EventComment')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-eventComment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-eventComment" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="comment" title="${message(code: 'eventComment.comment.label', default: 'Comment')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'eventComment.dateCreated.label', default: 'Date Created')}" />
					
						<th><g:message code="eventComment.event.label" default="Event" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${eventCommentInstanceList}" status="i" var="eventCommentInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${eventCommentInstance.id}">${fieldValue(bean: eventCommentInstance, field: "comment")}</g:link></td>
					
						<td><g:formatDate date="${eventCommentInstance.dateCreated}" /></td>
					
						<td>${fieldValue(bean: eventCommentInstance, field: "event")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${eventCommentInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
