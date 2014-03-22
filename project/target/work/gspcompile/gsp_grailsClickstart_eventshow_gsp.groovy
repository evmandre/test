import grails.clickstart.Event
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_grailsClickstart_eventshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/event/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'event.label', default: 'Event'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (eventInstance?.description)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("event.description.label"),'default':("Description")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(eventInstance),'field':("description")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (eventInstance?.category)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("event.category.label"),'default':("Category")],-1)
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(eventInstance?.category?.encodeAsHTML())
})
invokeTag('link','g',39,['controller':("eventCategory"),'action':("show"),'id':(eventInstance?.category?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (eventInstance?.comments)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("event.comments.label"),'default':("Comments")],-1)
printHtmlPart(21)
for( c in (eventInstance.comments) ) {
printHtmlPart(22)
createTagBody(4, {->
expressionOut.print(c?.encodeAsHTML())
})
invokeTag('link','g',49,['controller':("eventComment"),'action':("show"),'id':(c.id)],4)
printHtmlPart(23)
}
printHtmlPart(24)
}
printHtmlPart(17)
if(true && (eventInstance?.contactInfo)) {
printHtmlPart(25)
invokeTag('message','g',57,['code':("event.contactInfo.label"),'default':("Contact Info")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',59,['bean':(eventInstance),'field':("contactInfo")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (eventInstance?.dateOfEvent)) {
printHtmlPart(27)
invokeTag('message','g',66,['code':("event.dateOfEvent.label"),'default':("Date Of Event")],-1)
printHtmlPart(28)
invokeTag('formatDate','g',68,['date':(eventInstance?.dateOfEvent)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (eventInstance?.eventTitle)) {
printHtmlPart(29)
invokeTag('message','g',75,['code':("event.eventTitle.label"),'default':("Event Title")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',77,['bean':(eventInstance),'field':("eventTitle")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (eventInstance?.fee)) {
printHtmlPart(31)
invokeTag('message','g',84,['code':("event.fee.label"),'default':("Fee")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',86,['bean':(eventInstance),'field':("fee")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (eventInstance?.type)) {
printHtmlPart(33)
invokeTag('message','g',93,['code':("event.type.label"),'default':("Type")],-1)
printHtmlPart(34)
createTagBody(3, {->
expressionOut.print(eventInstance?.type?.encodeAsHTML())
})
invokeTag('link','g',95,['controller':("eventType"),'action':("show"),'id':(eventInstance?.type?.id)],3)
printHtmlPart(16)
}
printHtmlPart(35)
createTagBody(2, {->
printHtmlPart(36)
createTagBody(3, {->
invokeTag('message','g',103,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',103,['class':("edit"),'action':("edit"),'resource':(eventInstance)],3)
printHtmlPart(37)
invokeTag('actionSubmit','g',104,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(38)
})
invokeTag('form','g',106,['url':([resource:eventInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(39)
})
invokeTag('captureBody','sitemesh',108,[:],1)
printHtmlPart(40)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1393994231000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
