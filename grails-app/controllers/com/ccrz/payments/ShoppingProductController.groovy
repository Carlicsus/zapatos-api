package com.ccrz.payments

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ShoppingProductController {

    ShoppingProductService shoppingProductService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond shoppingProductService.list(params), model:[shoppingProductCount: shoppingProductService.count()]
    }

    def show(Long id) {
        respond shoppingProductService.get(id)
    }

    def save(ShoppingProduct shoppingProduct) {
        if (shoppingProduct == null) {
            render status: NOT_FOUND
            return
        }

        try {
            shoppingProductService.save(shoppingProduct)
        } catch (ValidationException e) {
            respond shoppingProduct.errors, view:'create'
            return
        }

        respond shoppingProduct, [status: CREATED, view:"show"]
    }

    def update(ShoppingProduct shoppingProduct) {
        if (shoppingProduct == null) {
            render status: NOT_FOUND
            return
        }

        try {
            shoppingProductService.save(shoppingProduct)
        } catch (ValidationException e) {
            respond shoppingProduct.errors, view:'edit'
            return
        }

        respond shoppingProduct, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        shoppingProductService.delete(id)

        render status: NO_CONTENT
    }
}
