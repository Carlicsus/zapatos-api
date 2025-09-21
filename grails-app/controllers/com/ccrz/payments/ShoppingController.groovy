package com.ccrz.payments

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ShoppingController {

    ShoppingService shoppingService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond shoppingService.list(params), model:[shoppingCount: shoppingService.count()]
    }

    def show(Long id) {
        respond shoppingService.get(id)
    }

    def save(Shopping shopping) {
        if (shopping == null) {
            render status: NOT_FOUND
            return
        }

        try {
            shoppingService.save(shopping)
        } catch (ValidationException e) {
            respond shopping.errors, view:'create'
            return
        }

        respond shopping, [status: CREATED, view:"show"]
    }

    def update(Shopping shopping) {
        if (shopping == null) {
            render status: NOT_FOUND
            return
        }

        try {
            shoppingService.save(shopping)
        } catch (ValidationException e) {
            respond shopping.errors, view:'edit'
            return
        }

        respond shopping, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        shoppingService.delete(id)

        render status: NO_CONTENT
    }
}
