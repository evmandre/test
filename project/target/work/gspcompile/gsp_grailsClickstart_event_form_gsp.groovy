import grails.clickstart.Event
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_grailsClickstart_event_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/event/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: eventInstance, field: 'description', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("event.description.label"),'default':("Description")],-1)
printHtmlPart(2)
invokeTag('textArea','g',10,['name':("description"),'cols':("40"),'rows':("5"),'maxlength':("5000"),'value':(eventInstance?.description)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: eventInstance, field: 'category', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("event.category.label"),'default':("Category")],-1)
printHtmlPart(5)
invokeTag('select','g',18,['id':("category"),'name':("category.id"),'from':(grails.clickstart.EventCategory.list()),'optionKey':("id"),'required':(""),'value':(eventInstance?.category?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: eventInstance, field: 'comments', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("event.comments.label"),'default':("Comments")],-1)
printHtmlPart(7)
for( c in (eventInstance?.comments) ) {
printHtmlPart(8)
createTagBody(2, {->
expressionOut.print(c?.encodeAsHTML())
})
invokeTag('link','g',29,['controller':("eventComment"),'action':("show"),'id':(c.id)],2)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'eventComment.label', default: 'EventComment')]))
})
invokeTag('link','g',32,['controller':("eventComment"),'action':("create"),'params':(['event.id': eventInstance?.id])],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: eventInstance, field: 'contactInfo', 'error'))
printHtmlPart(12)
invokeTag('message','g',40,['code':("event.contactInfo.label"),'default':("Contact Info")],-1)
printHtmlPart(2)
invokeTag('textField','g',43,['name':("contactInfo"),'value':(eventInstance?.contactInfo)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: eventInstance, field: 'dateOfEvent', 'error'))
printHtmlPart(13)
invokeTag('message','g',48,['code':("event.dateOfEvent.label"),'default':("Date Of Event")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',51,['name':("dateOfEvent"),'precision':("day"),'value':(eventInstance?.dateOfEvent)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: eventInstance, field: 'eventTitle', 'error'))
printHtmlPart(14)
invokeTag('message','g',56,['code':("event.eventTitle.label"),'default':("Event Title")],-1)
printHtmlPart(2)
invokeTag('textField','g',59,['name':("eventTitle"),'value':(eventInstance?.eventTitle)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: eventInstance, field: 'fee', 'error'))
printHtmlPart(15)
invokeTag('message','g',64,['code':("event.fee.label"),'default':("Fee")],-1)
printHtmlPart(5)
invokeTag('field','g',67,['name':("fee"),'value':(fieldValue(bean: eventInstance, field: 'fee')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: eventInstance, field: 'type', 'error'))
printHtmlPart(16)
invokeTag('message','g',72,['code':("event.type.label"),'default':("Type")],-1)
printHtmlPart(5)
invokeTag('select','g',75,['id':("type"),'name':("type.id"),'from':(grails.clickstart.EventType.list()),'optionKey':("id"),'required':(""),'value':(eventInstance?.type?.id),'class':("many-to-one")],-1)
printHtmlPart(17)
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
