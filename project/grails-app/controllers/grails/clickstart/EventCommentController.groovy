package grails.clickstart



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EventCommentController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EventComment.list(params), model:[eventCommentInstanceCount: EventComment.count()]
    }

    def show(EventComment eventCommentInstance) {
        respond eventCommentInstance
    }

    def create() {
        respond new EventComment(params)
    }

    @Transactional
    def save(EventComment eventCommentInstance) {
        if (eventCommentInstance == null) {
            notFound()
            return
        }

        if (eventCommentInstance.hasErrors()) {
            respond eventCommentInstance.errors, view:'create'
            return
        }

        eventCommentInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'eventCommentInstance.label', default: 'EventComment'), eventCommentInstance.id])
                redirect eventCommentInstance
            }
            '*' { respond eventCommentInstance, [status: CREATED] }
        }
    }

    def edit(EventComment eventCommentInstance) {
        respond eventCommentInstance
    }

    @Transactional
    def update(EventComment eventCommentInstance) {
        if (eventCommentInstance == null) {
            notFound()
            return
        }

        if (eventCommentInstance.hasErrors()) {
            respond eventCommentInstance.errors, view:'edit'
            return
        }

        eventCommentInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EventComment.label', default: 'EventComment'), eventCommentInstance.id])
                redirect eventCommentInstance
            }
            '*'{ respond eventCommentInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(EventComment eventCommentInstance) {

        if (eventCommentInstance == null) {
            notFound()
            return
        }

        eventCommentInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EventComment.label', default: 'EventComment'), eventCommentInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'eventCommentInstance.label', default: 'EventComment'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
