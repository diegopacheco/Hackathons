package gambetta.system

public class Tweet {
	String msg
		
	static constraints = {
		msg(maxLength:120,blank:false)
	}
	
}