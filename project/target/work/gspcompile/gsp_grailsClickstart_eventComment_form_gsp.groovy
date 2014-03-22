import grails.clickstart.EventComment
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_grailsClickstart_eventComment_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/eventComment/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: eventCommentInstance, field: 'comment', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("eventComment.comment.label"),'default':("Comment")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("comment"),'value':(eventCommentInstance?.comment)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: eventCommentInstance, field: 'event', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("eventComment.event.label"),'default':("Event")],-1)
printHtmlPart(5)
invokeTag('select','g',18,['id':("event"),'name':("event.id"),'from':(grails.clickstart.Event.list()),'optionKey':("id"),'required':(""),'value':(eventCommentInstance?.event?.id),'class':("many-to-one")],-1)
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
