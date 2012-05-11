package gambetta.system
import grails.converters.*
class FaultController {
	static scaffold = Fault
	
	def getFaultValue = {
		def fault = Fault.get(params.id)
		println fault;
		render fault?.price
	}
}
