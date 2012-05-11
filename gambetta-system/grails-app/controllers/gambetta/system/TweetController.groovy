package gambetta.system

import org.springframework.dao.DataIntegrityViolationException

class TweetController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [tweetInstanceList: Tweet.list(params), tweetInstanceTotal: Tweet.count()]
    }

    def create() {
        [tweetInstance: new Tweet(params)]
    }

    def save() {
		def x = new TwitterService(TweetAcountInformation.get(1))
		def result = x.tweet("${params.msg} ${new java.util.Date()}")
		
		flash.message = message(code: 'default.created.message', args: [message(code: 'tweet.label', default: 'Tweet'), 1])
        redirect(action: "show", id: 1)
    }

    def show() {
        def tweetInstance = Tweet.get(params.id)
        if (!tweetInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'tweet.label', default: 'Tweet'), params.id])
            redirect(action: "list")
            return
        }

        [tweetInstance: tweetInstance]
    }

    def edit() {
        def tweetInstance = Tweet.get(params.id)
        if (!tweetInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tweet.label', default: 'Tweet'), params.id])
            redirect(action: "list")
            return
        }

        [tweetInstance: tweetInstance]
    }

    def update() {
        def tweetInstance = Tweet.get(params.id)
        if (!tweetInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tweet.label', default: 'Tweet'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (tweetInstance.version > version) {
                tweetInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'tweet.label', default: 'Tweet')] as Object[],
                          "Another user has updated this Tweet while you were editing")
                render(view: "edit", model: [tweetInstance: tweetInstance])
                return
            }
        }

        tweetInstance.properties = params

        if (!tweetInstance.save(flush: true)) {
            render(view: "edit", model: [tweetInstance: tweetInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'tweet.label', default: 'Tweet'), tweetInstance.id])
        redirect(action: "show", id: tweetInstance.id)
    }

    def delete() {
        def tweetInstance = Tweet.get(params.id)
        if (!tweetInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'tweet.label', default: 'Tweet'), params.id])
            redirect(action: "list")
            return
        }

        try {
            tweetInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'tweet.label', default: 'Tweet'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'tweet.label', default: 'Tweet'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
