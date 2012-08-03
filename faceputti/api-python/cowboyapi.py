from twisted.web import server, resource
from twisted.internet import reactor

class CowboyResource(resource.Resource):
    isLeaf = True
    numberRequests = 0
    
    def render_GET(self, request):
        request.setHeader("content-type", "text/plain")
        return "I am cowboy bicth\n"

reactor.listenTCP(8080, server.Site(CowboyResource()))
reactor.run()