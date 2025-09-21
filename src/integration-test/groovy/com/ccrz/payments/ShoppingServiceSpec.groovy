package com.ccrz.payments

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ShoppingServiceSpec extends Specification {

    ShoppingService shoppingService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Shopping(...).save(flush: true, failOnError: true)
        //new Shopping(...).save(flush: true, failOnError: true)
        //Shopping shopping = new Shopping(...).save(flush: true, failOnError: true)
        //new Shopping(...).save(flush: true, failOnError: true)
        //new Shopping(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //shopping.id
    }

    void "test get"() {
        setupData()

        expect:
        shoppingService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Shopping> shoppingList = shoppingService.list(max: 2, offset: 2)

        then:
        shoppingList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        shoppingService.count() == 5
    }

    void "test delete"() {
        Long shoppingId = setupData()

        expect:
        shoppingService.count() == 5

        when:
        shoppingService.delete(shoppingId)
        sessionFactory.currentSession.flush()

        then:
        shoppingService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Shopping shopping = new Shopping()
        shoppingService.save(shopping)

        then:
        shopping.id != null
    }
}
