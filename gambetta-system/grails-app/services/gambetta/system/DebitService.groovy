package gambetta.system

class DebitService {

    def saveWorkaround(debitInstance) {
      if (!debitInstance.save(flush: true)) return false
      
      def twitterService = new TwitterService()
      twitterService.tweet("TestTweet", "g@mbetinh@")
      return true
    }

}
