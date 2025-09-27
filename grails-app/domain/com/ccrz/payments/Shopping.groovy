package com.ccrz.payments

import java.math.RoundingMode

class Shopping implements Serializable{
    String uuid = UUID.randomUUID().toString().replaceAll('\\-','')

    String numberOrder
    String state
    Double subTotal
    Integer discount
    Double shippingCost
    Integer tax
    Double total
    String status
    Date dateCreated
    Date lastUpdated

    static hasOne = [payment: Payment]


    static constraints = {
        uuid            nullable: false, blank: false, maxSize: 36

        numberOrder     nullable: false, blank:false, size:1..11, matches:"[a-zA-Z0-9_]+"
        state           nullable: false, inList: ['pendiente','procesada','enviada','completada','cancelada']
        subTotal        nullable: false
        discount        nullable: true
        shippingCost    nullable: true
        tax             nullable: true
        total           nullable: false
        status inList : ["active", "inactive"]
    }

    static mapping = {
        table 'tbb_shoppings'
        version false

        id name: 'uuid', column: 'uuid', generator: 'assigned'

        payment lazy: false

        columns: {
            numberOrder     column: 'number_order'
            state           column: 'state'
            subTotal        column: 'sub_total'
            discount        column: 'discount'
            shippingCost    column: 'shipping_cost'
            tax             column: 'tax'
            total           column: 'total'
            dateCreated     column: 'created_at'
            lastUpdated     column: 'updated_at'
        }

    }
    def beforeValidate(){
        if(discount != null || shippingCost != null || tax != null){
            Double taxF = ((subTotal/100)*tax).setScale(2, RoundingMode.HALF_UP)
            subTotal = (subTotal - ((subTotal/100)*discount)).setScale(2, RoundingMode.HALF_UP)

            total = subTotal+taxF+shippingCost
        }
    }
    def beforeInsert() { beforeValidate() }
    def beforeUpdate() { beforeValidate() }
}
