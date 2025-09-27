package com.ccrz.users

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    // Obtener usuarios con criterios de filtrado
    def getUsersWithCriteria(def params) {
        def criteria = User.createCriteria()
        def users = criteria.list(max: params.max ?: 10, offset: params.offset ?: 0) {
            if (params.name) {
                ilike('name', "%${params.name}%")
            }
            if (params.email) {
                eq('email', params.email)
            }
            if (params.status) {
                eq('status', params.status)
            }
            // Aquí puedes agregar más criterios de búsqueda según las necesidades
        }
        return users
    }

    // Obtener un usuario por su ID (UUID)
    def getUserById(String id) {
        return User.findByUuid(id)
    }
}
