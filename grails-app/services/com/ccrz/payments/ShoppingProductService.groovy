package com.ccrz.payments

import grails.gorm.services.Service

@Service(ShoppingProduct)
interface ShoppingProductService {

    ShoppingProduct get(Serializable id)

    List<ShoppingProduct> list(Map args)

    Long count()

    void delete(Serializable id)

    ShoppingProduct save(ShoppingProduct shoppingProduct)

}