package com.ccrz.users

import grails.transaction.Transactional
import org.springframework.http.HttpStatus

@Transactional
class UserController {

    UserService userService

    // Acción para obtener la lista de usuarios (con criterios)
    def index() {
        // Aquí puedes obtener los parámetros de la consulta y pasarlos al servicio para aplicar los filtros
        def criteria = params
        def users = userService.getUsersWithCriteria(criteria)
        [users]
    }

    // Acción para mostrar un usuario por su ID
    def show(String id) {
        def user = userService.getUserById(id)
        if (!user) {
            render status: HttpStatus.NOT_FOUND
        } else {
            [users]
        }
    }

    // Acción para crear un nuevo usuario
    def save() {
        def user = new User(params)
        if (user.save(flush: true)) {
            [users]
        } else {
            render status: HttpStatus.BAD_REQUEST
        }
    }

    // Acción para actualizar un usuario existente
    def update(String id) {
        def user = userService.getUserById(id)
        if (!user) {
            render status: HttpStatus.NOT_FOUND
        } else {
            user.properties = params
            if (user.save(flush: true)) {
                [users]
            } else {
                render status: HttpStatus.BAD_REQUEST
            }
        }
    }

    // Acción para eliminar un usuario
    def delete(String id) {
        def user = userService.getUserById(id)
        if (!user) {
            render status: HttpStatus.NOT_FOUND
        } else {
            user.delete(flush: true)
            render status: HttpStatus.NO_CONTENT
        }
    }
}
