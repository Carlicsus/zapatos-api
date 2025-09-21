package com.ccrz.payments

class Payment {
    String provideer
    String token
    String brand
    String last4
    Date expirationDate
    String state
    int transactionId
    Double originalAmount
    String originalCurrency
    String exchangeRate
    Boolean status
    Date dateCreated
    Date lastUpdated

    Shopping shoppingId

    static constraints = {
        provideer(nullable:false, size:5..20)
        token(nullable:false, size:5..20, blank:false)
        brand(nullable:false, size:5..20)
        last4(nullable:false, size:4..4)
        exchangeRate(nullable:false)
        state(nullable:false, size:5..20, inList: ['pendiente','procesado','completado','cancelado','revotado'])
        transactionId(nullable:false)
        originalAmount(nullable:false)
        originalCurrency(nullable:false)
        exchangeRate(nullable:false)
    }

    static mapping = {
        table "tbb_payments"
        version false
    }
}
