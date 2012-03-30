package gambetta.system

class HomeController {
	
	def index(){
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		render (view: "index", model: [workarounders: Workarounder.list(params), workarounderCount: Workarounder.count()])
	}
}
