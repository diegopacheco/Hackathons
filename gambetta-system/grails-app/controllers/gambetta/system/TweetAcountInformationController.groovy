package gambetta.system

import org.springframework.dao.DataIntegrityViolationException

class TweetAcountInformationController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [tweetAcountInformationInstanceList: TweetAcountInformation.list(params), tweetAcountInformationInstanceTotal: TweetAcountInformation.count()]
    }

    def create() {
        [tweetAcountInformationInstance: new TweetAcountInformation(params)]
    }

    def save() {
        def tweetAcountInformationInstance = new TweetAcountInformation(params)
        if (!tweetAcountInformationInstance.save(flush: true)) {
            render(view: "create", model: [tweetAcountInformationInstance: tweetAcountInformationInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'tweetAcountInformation.label', default: 'TweetAcountInformation'), tweetAcountInformationInstance.id])
        redirect(action: "show", id: tweetAcountInformationInstance.id)
    }

    def show() {
        def tweetAcountInformationInstance = TweetAcountInformation.get(params.id)
        if (!tweetAcountInformationInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'tweetAcountInformation.label', default: 'TweetAcountInformation'), params.id])
            redirect(action: "list")
            return
        }

        [tweetAcountInformationInstance: tweetAcountInformationInstance]
    }

    def edit() {
        def tweetAcountInformationInstance = TweetAcountInformation.get(params.id)
        if (!tweetAcountInformationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tweetAcountInformation.label', default: 'TweetAcountInformation'), params.id])
            redirect(action: "list")
            return
        }

        [tweetAcountInformationInstance: tweetAcountInformationInstance]
    }

    def update() {
        def tweetAcountInformationInstance = TweetAcountInformation.get(params.id)
        if (!tweetAcountInformationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tweetAcountInformation.label', default: 'TweetAcountInformation'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (tweetAcountInformationInstance.version > version) {
                tweetAcountInformationInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'tweetAcountInformation.label', default: 'TweetAcountInformation')] as Object[],
                          "Another user has updated this TweetAcountInformation while you were editing")
                render(view: "edit", model: [tweetAcountInformationInstance: tweetAcountInformationInstance])
                return
            }
        }

        tweetAcountInformationInstance.properties = params

        if (!tweetAcountInformationInstance.save(flush: true)) {
            render(view: "edit", model: [tweetAcountInformationInstance: tweetAcountInformationInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'tweetAcountInformation.label', default: 'TweetAcountInformation'), tweetAcountInformationInstance.id])
        redirect(action: "show", id: tweetAcountInformationInstance.id)
    }

    def delete() {
        def tweetAcountInformationInstance = TweetAcountInformation.get(params.id)
        if (!tweetAcountInformationInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'tweetAcountInformation.label', default: 'TweetAcountInformation'), params.id])
            redirect(action: "list")
            return
        }

        try {
            tweetAcountInformationInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'tweetAcountInformation.label', default: 'TweetAcountInformation'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'tweetAcountInformation.label', default: 'TweetAcountInformation'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
