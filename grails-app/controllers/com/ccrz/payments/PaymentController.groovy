package com.ccrz.payments

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PaymentController {

    PaymentService paymentService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond paymentService.list(params), model:[paymentCount: paymentService.count()]
    }

    def show(Long id) {
        respond paymentService.get(id)
    }

    def save(Payment payment) {
        if (payment == null) {
            render status: NOT_FOUND
            return
        }

        try {
            paymentService.save(payment)
        } catch (ValidationException e) {
            respond payment.errors, view:'create'
            return
        }

        respond payment, [status: CREATED, view:"show"]
    }

    def update(Payment payment) {
        if (payment == null) {
            render status: NOT_FOUND
            return
        }

        try {
            paymentService.save(payment)
        } catch (ValidationException e) {
            respond payment.errors, view:'edit'
            return
        }

        respond payment, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        paymentService.delete(id)

        render status: NO_CONTENT
    }
}
