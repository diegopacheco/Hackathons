package gambetta.system

public class TweetAcountInformation {
	
	String oAuthConsumerKey
	String oAuthConsumerSecret
	String oAuthAccessToken
	String oAuthAccessTokenSecret
		
	static constraints = {
		oAuthConsumerKey(blank:false)
		oAuthConsumerSecret(blank:false)
		oAuthAccessToken(blank:false)
		oAuthAccessTokenSecret(blank:false)
	}
	
}