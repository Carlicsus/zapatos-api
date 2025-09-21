package com.ccrz.payments

class ShoppingProduct {
    int amount
    Double unitPrice
    Double total
    Boolean status
    Date dateCreated

    Shopping shoppingId
    // Product productId

    static constraints = {
        amount(nullable:false)
        unitPrice(nullable:false)
        total(nullable:false)
    }

    static mapping = {
        table "tbb_products_shopping"
        version false
    }
}
