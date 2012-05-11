package gambetta.system

public class Tweet {
	String pin
	String msg
		
	static constraints = {
		pin(blank:false)
		msg(maxLength:120,blank:false)
	}
	
}