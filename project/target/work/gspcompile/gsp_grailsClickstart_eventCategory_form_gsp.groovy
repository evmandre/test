import grails.clickstart.EventCategory
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_grailsClickstart_eventCategory_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/eventCategory/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: eventCategoryInstance, field: 'categoryName', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("eventCategory.categoryName.label"),'default':("Category Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("categoryName"),'value':(eventCategoryInstance?.categoryName)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: eventCategoryInstance, field: 'event', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("eventCategory.event.label"),'default':("Event")],-1)
printHtmlPart(5)
for( e in (eventCategoryInstance?.event) ) {
printHtmlPart(6)
createTagBody(2, {->
expressionOut.print(e?.encodeAsHTML())
})
invokeTag('link','g',21,['controller':("event"),'action':("show"),'id':(e.id)],2)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'event.label', default: 'Event')]))
})
invokeTag('link','g',24,['controller':("event"),'action':("create"),'params':(['eventCategory.id': eventCategoryInstance?.id])],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: eventCategoryInstance, field: 'type', 'error'))
printHtmlPart(10)
invokeTag('message','g',32,['code':("eventCategory.type.label"),'default':("Type")],-1)
printHtmlPart(5)
for( t in (eventCategoryInstance?.type) ) {
printHtmlPart(6)
createTagBody(2, {->
expressionOut.print(t?.encodeAsHTML())
})
invokeTag('link','g',38,['controller':("eventType"),'action':("show"),'id':(t.id)],2)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'eventType.label', default: 'EventType')]))
})
invokeTag('link','g',41,['controller':("eventType"),'action':("create"),'params':(['eventCategory.id': eventCategoryInstance?.id])],1)
printHtmlPart(11)
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
