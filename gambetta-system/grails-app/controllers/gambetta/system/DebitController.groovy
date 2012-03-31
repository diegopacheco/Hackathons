package gambetta.system

import org.springframework.dao.DataIntegrityViolationException

class DebitController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [debitInstanceList: Debit.list(params), debitInstanceTotal: Debit.count()]
    }

    def create() {
        [debitInstance: new Debit(params)]
    }

    def save() {
        def debitInstance = new Debit(params)
        def serviceInstance = new DebitService()
        if (!serviceInstance.saveWorkaround(debitInstance)) {
            render(view: "create", model: [debitInstance: debitInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'debit.label', default: 'Debit'), debitInstance.id])
        redirect(action: "show", id: debitInstance.id)
    }

    def show() {
        def debitInstance = Debit.get(params.id)
        if (!debitInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'debit.label', default: 'Debit'), params.id])
            redirect(action: "list")
            return
        }

        [debitInstance: debitInstance]
    }

    def edit() {
        def debitInstance = Debit.get(params.id)
        if (!debitInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'debit.label', default: 'Debit'), params.id])
            redirect(action: "list")
            return
        }

        [debitInstance: debitInstance]
    }

    def update() {
        def debitInstance = Debit.get(params.id)
        if (!debitInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'debit.label', default: 'Debit'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (debitInstance.version > version) {
                debitInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'debit.label', default: 'Debit')] as Object[],
                          "Another user has updated this Debit while you were editing")
                render(view: "edit", model: [debitInstance: debitInstance])
                return
            }
        }

        debitInstance.properties = params

        if (!debitInstance.save(flush: true)) {
            render(view: "edit", model: [debitInstance: debitInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'debit.label', default: 'Debit'), debitInstance.id])
        redirect(action: "show", id: debitInstance.id)
    }

    def delete() {
        def debitInstance = Debit.get(params.id)
        if (!debitInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'debit.label', default: 'Debit'), params.id])
            redirect(action: "list")
            return
        }

        try {
            debitInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'debit.label', default: 'Debit'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'debit.label', default: 'Debit'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
