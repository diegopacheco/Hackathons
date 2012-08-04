import tweepy

auth = tweepy.OAuthHandler('applicationToken', 'applicationKey')
auth.set_access_token('oauthAccessToken', 'oauthAccessKey')

api = tweepy.API(auth)

api.update_status_with_media('C:\\Users\\Jeferson\\Desktop\\hellYeah.jpg', 'image/jpeg', 'tweeting from tweepy!! HELL YEAH!!!')

#Just a simple testing code