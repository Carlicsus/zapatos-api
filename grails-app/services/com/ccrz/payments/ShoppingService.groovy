package com.ccrz.payments

import grails.gorm.services.Service

@Service(Shopping)
interface ShoppingService {

    Shopping get(Serializable id)

    List<Shopping> list(Map args)

    Long count()

    void delete(Serializable id)

    Shopping save(Shopping shopping)

}