package gambetta.system



import org.junit.*
import grails.test.mixin.*

@TestFor(WorkarounderController)
@Mock(Workarounder)
class WorkarounderControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/workarounder/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.workarounderInstanceList.size() == 0
        assert model.workarounderInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.workarounderInstance != null
    }

    void testSave() {
        controller.save()

        assert model.workarounderInstance != null
        assert view == '/workarounder/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/workarounder/show/1'
        assert controller.flash.message != null
        assert Workarounder.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/workarounder/list'


        populateValidParams(params)
        def workarounder = new Workarounder(params)

        assert workarounder.save() != null

        params.id = workarounder.id

        def model = controller.show()

        assert model.workarounderInstance == workarounder
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/workarounder/list'


        populateValidParams(params)
        def workarounder = new Workarounder(params)

        assert workarounder.save() != null

        params.id = workarounder.id

        def model = controller.edit()

        assert model.workarounderInstance == workarounder
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/workarounder/list'

        response.reset()


        populateValidParams(params)
        def workarounder = new Workarounder(params)

        assert workarounder.save() != null

        // test invalid parameters in update
        params.id = workarounder.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/workarounder/edit"
        assert model.workarounderInstance != null

        workarounder.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/workarounder/show/$workarounder.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        workarounder.clearErrors()

        populateValidParams(params)
        params.id = workarounder.id
        params.version = -1
        controller.update()

        assert view == "/workarounder/edit"
        assert model.workarounderInstance != null
        assert model.workarounderInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/workarounder/list'

        response.reset()

        populateValidParams(params)
        def workarounder = new Workarounder(params)

        assert workarounder.save() != null
        assert Workarounder.count() == 1

        params.id = workarounder.id

        controller.delete()

        assert Workarounder.count() == 0
        assert Workarounder.get(workarounder.id) == null
        assert response.redirectedUrl == '/workarounder/list'
    }
}
