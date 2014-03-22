import grails.clickstart.EventType
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_grailsClickstart_eventType_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/eventType/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: eventTypeInstance, field: 'category', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("eventType.category.label"),'default':("Category")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("category"),'name':("category.id"),'from':(grails.clickstart.EventCategory.list()),'optionKey':("id"),'required':(""),'value':(eventTypeInstance?.category?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: eventTypeInstance, field: 'typeofCategory', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("eventType.typeofCategory.label"),'default':("Typeof Category")],-1)
printHtmlPart(5)
invokeTag('textField','g',18,['name':("typeofCategory"),'value':(eventTypeInstance?.typeofCategory)],-1)
printHtmlPart(6)
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
