package com.ccrz.payments

class Shopping {
    int id
    String numberOrder
    String state
    Double subtotal
    int discount
    Double shippingCost
    int tax
    Double total
    Boolean status
    Date dateCreated
    Date lastUpdated

    // User userId;
    // Address addressId;

    static constraints = {
        numberOrder(blank:false, nullable:false, size:1..11, matches:"[a-zA-Z0-9_]+")
        state(nullable:false, inList: ['pendiente','procesada','enviada','completada','cancelada'])
        subtotal(nullable:false)
        discount(nullable:true)
        shippingCost(nullable:true)
        tax(nullable:true)
        total(nullable:false)
    }

    static mapping = {
        table 'shoppings'
        version false
    }
}
