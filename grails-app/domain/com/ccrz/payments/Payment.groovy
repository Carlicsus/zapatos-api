package com.ccrz.payments

class Payment implements Serializable{
    String uuid = UUID.randomUUID().toString().replaceAll('\\-','')

    // Shopping uuid_shopping

    String provideer
    String token
    String brand
    String last4
    Date expirationDate
    String state
    Integer transactionId
    Double originalAmount
    String originalCurrency
    String exchangeRate
    String status
    Date dateCreated
    Date lastUpdated

    static belongsTo = [shopping: Shopping]

    static constraints = {
        uuid                nullable: false, blank: false, maxSize: 36
        // uuid_shopping       nullable: false, blank: false, maxSize: 36
        provideer           nullable: false, size: 5..20
        token               nullable: false, size: 5..20, blank: false
        brand               nullable: false, size: 5..20
        last4               nullable: false, size: 4 ..4
        expirationDate      nullable: false
        state               nullable: false, size: 5..20, inList: ['pendiente','procesado','completado','cancelado','revotado']
        transactionId       nullable: false
        originalAmount      nullable: false
        originalCurrency    nullable: false
        exchangeRate        nullable: false
        status inList : ["active", "inactive"]
    }

    static mapping = {
        table 'tbb_payments'
        version false

        id name: 'uuid', column: 'uuid', generator: 'assigned'

        columns: {
            shopping    unique: true
            // uuid_shopping       column: 'uuid_shopping', unique: true
            provideer           column: 'procideer'
            token               column: 'token'
            brand               column: 'brand'
            last4               column: 'last_numbers'
            expirationDate      column: 'exchange_rate'
            state               column: 'state'
            transactionId       column: 'transaction_id'
            originalAmount      column: 'original_amount'
            originalCurrency    column: 'original_currency'
            exchangeRate        column: 'exchan'
            status              column: 'status'
            dateCreated         column: 'created_at'
            lastUpdated         column: 'updated_at'
        }
    }
}
