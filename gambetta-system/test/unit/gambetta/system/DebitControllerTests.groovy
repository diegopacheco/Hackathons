package gambetta.system



import org.junit.*
import grails.test.mixin.*

@TestFor(DebitController)
@Mock(Debit)
class DebitControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/debit/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.debitInstanceList.size() == 0
        assert model.debitInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.debitInstance != null
    }

    void testSave() {
        controller.save()

        assert model.debitInstance != null
        assert view == '/debit/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/debit/show/1'
        assert controller.flash.message != null
        assert Debit.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/debit/list'


        populateValidParams(params)
        def debit = new Debit(params)

        assert debit.save() != null

        params.id = debit.id

        def model = controller.show()

        assert model.debitInstance == debit
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/debit/list'


        populateValidParams(params)
        def debit = new Debit(params)

        assert debit.save() != null

        params.id = debit.id

        def model = controller.edit()

        assert model.debitInstance == debit
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/debit/list'

        response.reset()


        populateValidParams(params)
        def debit = new Debit(params)

        assert debit.save() != null

        // test invalid parameters in update
        params.id = debit.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/debit/edit"
        assert model.debitInstance != null

        debit.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/debit/show/$debit.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        debit.clearErrors()

        populateValidParams(params)
        params.id = debit.id
        params.version = -1
        controller.update()

        assert view == "/debit/edit"
        assert model.debitInstance != null
        assert model.debitInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/debit/list'

        response.reset()

        populateValidParams(params)
        def debit = new Debit(params)

        assert debit.save() != null
        assert Debit.count() == 1

        params.id = debit.id

        controller.delete()

        assert Debit.count() == 0
        assert Debit.get(debit.id) == null
        assert response.redirectedUrl == '/debit/list'
    }
}
