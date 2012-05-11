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
   
   public TwitterService(){
        cb.setDebugEnabled(true)
          .setOAuthConsumerKey("7KhiEFkUqWMySaS747Xt7g")
          .setOAuthConsumerSecret("JnFs1kZCgmFqe0OZlqGUar5NZDmQrmSNFDayUjmvds")
          .setOAuthAccessToken("229474714-8rCHl1cJ7lHXf1lsl2qQx5MFA03C1xBEGtJkWBqV")
          .setOAuthAccessTokenSecret("Bg0bO3Yk5x52Wico1XdvondMnJF0NLHNxM7k1zUZOM")
        twitter = new TwitterFactory(cb.build()).getInstance()
   }
                  
   def tweet(msg,pin){
        try {          
              try{
                 RequestToken requestToken = twitter.getOAuthRequestToken()
                 accessToken = twitter.getOAuthAccessToken(requestToken, pin)
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

// x = new TwitterService()
// result = x.tweet("We Have a Class now !!! ","!!!!!warriors!!!!!")
// println result
