package gambetta.system

@Grab(group='org.twitter4j', module='twitter4j-core', version='2.2.5')
import twitter4j.*
import twitter4j.auth.*
import twitter4j.conf.*

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class TwitterService{
   
   ConfigurationBuilder cb = new ConfigurationBuilder()
   Twitter twitter = null
   
   public TwitterService(TweetAcountInformation tweetAcountInformation){
		//TODO: put it inside DATABASE
		
        cb.setDebugEnabled(true)
          .setOAuthConsumerKey(tweetAcountInformation.oAuthConsumerKey)
          .setOAuthConsumerSecret(tweetAcountInformation.oAuthConsumerSecret)
          .setOAuthAccessToken(tweetAcountInformation.oAuthAccessToken)
          .setOAuthAccessTokenSecret(tweetAcountInformation.oAuthAccessTokenSecret)
        twitter = new TwitterFactory(cb.build()).getInstance()
   }
                  
   def tweet(msg){
        try {          
              try{
                 RequestToken requestToken = twitter.getOAuthRequestToken()
                 accessToken = twitter.getOAuthAccessToken(requestToken)
              }catch(IllegalStateException ise){
                 // Yeah, it sucks! This API make us do that, this is a workaround forced by the API - Suck it up Poletto!
                 // Cuervo... Code man Code !!!
              }

              return twitter.updateStatus(msg)
        } catch (Exception e) {
              throw new RuntimeException(e)
        }
   }
   
}