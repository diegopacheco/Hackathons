package gambetta.system



import org.junit.*
import grails.test.mixin.*

@TestFor(TweetController)
@Mock(Tweet)
class TweetControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/tweet/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.tweetInstanceList.size() == 0
        assert model.tweetInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.tweetInstance != null
    }

    void testSave() {
        controller.save()

        assert model.tweetInstance != null
        assert view == '/tweet/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/tweet/show/1'
        assert controller.flash.message != null
        assert Tweet.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/tweet/list'


        populateValidParams(params)
        def tweet = new Tweet(params)

        assert tweet.save() != null

        params.id = tweet.id

        def model = controller.show()

        assert model.tweetInstance == tweet
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/tweet/list'


        populateValidParams(params)
        def tweet = new Tweet(params)

        assert tweet.save() != null

        params.id = tweet.id

        def model = controller.edit()

        assert model.tweetInstance == tweet
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/tweet/list'

        response.reset()


        populateValidParams(params)
        def tweet = new Tweet(params)

        assert tweet.save() != null

        // test invalid parameters in update
        params.id = tweet.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/tweet/edit"
        assert model.tweetInstance != null

        tweet.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/tweet/show/$tweet.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        tweet.clearErrors()

        populateValidParams(params)
        params.id = tweet.id
        params.version = -1
        controller.update()

        assert view == "/tweet/edit"
        assert model.tweetInstance != null
        assert model.tweetInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/tweet/list'

        response.reset()

        populateValidParams(params)
        def tweet = new Tweet(params)

        assert tweet.save() != null
        assert Tweet.count() == 1

        params.id = tweet.id

        controller.delete()

        assert Tweet.count() == 0
        assert Tweet.get(tweet.id) == null
        assert response.redirectedUrl == '/tweet/list'
    }
}
