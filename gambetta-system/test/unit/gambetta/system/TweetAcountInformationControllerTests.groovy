package gambetta.system



import org.junit.*
import grails.test.mixin.*

@TestFor(TweetAcountInformationController)
@Mock(TweetAcountInformation)
class TweetAcountInformationControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/tweetAcountInformation/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.tweetAcountInformationInstanceList.size() == 0
        assert model.tweetAcountInformationInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.tweetAcountInformationInstance != null
    }

    void testSave() {
        controller.save()

        assert model.tweetAcountInformationInstance != null
        assert view == '/tweetAcountInformation/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/tweetAcountInformation/show/1'
        assert controller.flash.message != null
        assert TweetAcountInformation.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/tweetAcountInformation/list'


        populateValidParams(params)
        def tweetAcountInformation = new TweetAcountInformation(params)

        assert tweetAcountInformation.save() != null

        params.id = tweetAcountInformation.id

        def model = controller.show()

        assert model.tweetAcountInformationInstance == tweetAcountInformation
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/tweetAcountInformation/list'


        populateValidParams(params)
        def tweetAcountInformation = new TweetAcountInformation(params)

        assert tweetAcountInformation.save() != null

        params.id = tweetAcountInformation.id

        def model = controller.edit()

        assert model.tweetAcountInformationInstance == tweetAcountInformation
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/tweetAcountInformation/list'

        response.reset()


        populateValidParams(params)
        def tweetAcountInformation = new TweetAcountInformation(params)

        assert tweetAcountInformation.save() != null

        // test invalid parameters in update
        params.id = tweetAcountInformation.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/tweetAcountInformation/edit"
        assert model.tweetAcountInformationInstance != null

        tweetAcountInformation.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/tweetAcountInformation/show/$tweetAcountInformation.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        tweetAcountInformation.clearErrors()

        populateValidParams(params)
        params.id = tweetAcountInformation.id
        params.version = -1
        controller.update()

        assert view == "/tweetAcountInformation/edit"
        assert model.tweetAcountInformationInstance != null
        assert model.tweetAcountInformationInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/tweetAcountInformation/list'

        response.reset()

        populateValidParams(params)
        def tweetAcountInformation = new TweetAcountInformation(params)

        assert tweetAcountInformation.save() != null
        assert TweetAcountInformation.count() == 1

        params.id = tweetAcountInformation.id

        controller.delete()

        assert TweetAcountInformation.count() == 0
        assert TweetAcountInformation.get(tweetAcountInformation.id) == null
        assert response.redirectedUrl == '/tweetAcountInformation/list'
    }
}
