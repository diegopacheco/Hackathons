package gambetta.system

import org.springframework.dao.DataIntegrityViolationException

class WorkarounderController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }
	
	def createReport = {
		def works = Workarounder.list()
		chain(controller:'jasper',action:'index',model:[data:works],params:params)
	}

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [workarounderInstanceList: Workarounder.list(params), workarounderInstanceTotal: Workarounder.count()]
    }

    def create() {
        [workarounderInstance: new Workarounder(params)]
    }

    def save() {
        def workarounderInstance = new Workarounder(params)
        if (!workarounderInstance.save(flush: true)) {
            render(view: "create", model: [workarounderInstance: workarounderInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'workarounder.label', default: 'Workarounder'), workarounderInstance.id])
        redirect(action: "show", id: workarounderInstance.id)
    }

    def show() {
        def workarounderInstance = Workarounder.get(params.id)
        if (!workarounderInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'workarounder.label', default: 'Workarounder'), params.id])
            redirect(action: "list")
            return
        }

        [workarounderInstance: workarounderInstance]
    }

    def edit() {
        def workarounderInstance = Workarounder.get(params.id)
        if (!workarounderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'workarounder.label', default: 'Workarounder'), params.id])
            redirect(action: "list")
            return
        }

        [workarounderInstance: workarounderInstance]
    }

    def update() {
        def workarounderInstance = Workarounder.get(params.id)
        if (!workarounderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'workarounder.label', default: 'Workarounder'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (workarounderInstance.version > version) {
                workarounderInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'workarounder.label', default: 'Workarounder')] as Object[],
                          "Another user has updated this Workarounder while you were editing")
                render(view: "edit", model: [workarounderInstance: workarounderInstance])
                return
            }
        }

        workarounderInstance.properties = params

        if (!workarounderInstance.save(flush: true)) {
            render(view: "edit", model: [workarounderInstance: workarounderInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'workarounder.label', default: 'Workarounder'), workarounderInstance.id])
        redirect(action: "show", id: workarounderInstance.id)
    }

    def delete() {
        def workarounderInstance = Workarounder.get(params.id)
        if (!workarounderInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'workarounder.label', default: 'Workarounder'), params.id])
            redirect(action: "list")
            return
        }

        try {
            workarounderInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'workarounder.label', default: 'Workarounder'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'workarounder.label', default: 'Workarounder'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
