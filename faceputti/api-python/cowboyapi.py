import datetime
from twisted.web import server, resource
from twisted.internet import reactor
from pymongo import Connection

class CowboyResource(resource.Resource):
	isLeaf = True
    
	def render_GET(self, request):
		request.setHeader("content-type", "application/json")
		connection = Connection()
		db = connection['cowboy-database']
		collection = db['cowboy-collection']
		user = {"name": "Poletto", "date": datetime.datetime.utcnow()}
		collection.insert(user)
		return collection.find_one({"name": "Poletto"})

reactor.listenTCP(8080, server.Site(CowboyResource()))
reactor.run()
