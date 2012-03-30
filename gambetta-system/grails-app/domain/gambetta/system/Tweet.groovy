package gambetta.system

public class Tweet {
	String pin
	String msg
		
	static constraints = {
		pin(blank:false)
		msg(blank:false)
	}
	
}