package grails.clickstart



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EventCategoryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EventCategory.list(params), model:[eventCategoryInstanceCount: EventCategory.count()]
    }

    def show(EventCategory eventCategoryInstance) {
        respond eventCategoryInstance
    }

    def create() {
        respond new EventCategory(params)
    }

    @Transactional
    def save(EventCategory eventCategoryInstance) {
        if (eventCategoryInstance == null) {
            notFound()
            return
        }

        if (eventCategoryInstance.hasErrors()) {
            respond eventCategoryInstance.errors, view:'create'
            return
        }

        eventCategoryInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'eventCategoryInstance.label', default: 'EventCategory'), eventCategoryInstance.id])
                redirect eventCategoryInstance
            }
            '*' { respond eventCategoryInstance, [status: CREATED] }
        }
    }

    def edit(EventCategory eventCategoryInstance) {
        respond eventCategoryInstance
    }

    @Transactional
    def update(EventCategory eventCategoryInstance) {
        if (eventCategoryInstance == null) {
            notFound()
            return
        }

        if (eventCategoryInstance.hasErrors()) {
            respond eventCategoryInstance.errors, view:'edit'
            return
        }

        eventCategoryInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EventCategory.label', default: 'EventCategory'), eventCategoryInstance.id])
                redirect eventCategoryInstance
            }
            '*'{ respond eventCategoryInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(EventCategory eventCategoryInstance) {

        if (eventCategoryInstance == null) {
            notFound()
            return
        }

        eventCategoryInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EventCategory.label', default: 'EventCategory'), eventCategoryInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'eventCategoryInstance.label', default: 'EventCategory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
