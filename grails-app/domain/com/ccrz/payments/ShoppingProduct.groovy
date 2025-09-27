package com.ccrz.payments

import com.ccrz.products.Product
import java.math.RoundingMode

class ShoppingProduct implements Serializable{
    
    Shopping shopping
    Product product

    Integer amount
    BigDecimal unitPrice
    BigDecimal total
    String status
    Date dateCreated
    Date lastUpdated

    static belongsTo = [shopping: Shopping, product: Product]

    static constraints = {
        shopping        nullable: false
        product         nullable: false
        amount          nullable: false, min: 1
        unitPrice       nullable: false, min: 0.00G, scale: 2
        total           nullable: false, min: 0.00G
        status inList : ["active", "inactive"]
    }

    static mapping = {
        table "tbb_products_shopping"
        version false

        id composite: ['shopping', 'product']

        columns {
            shopping        column: 'uuid_shopping'
            product         column: 'uuid_product'

            amount          column: 'amount'
            unitPrice       column: 'unit_price', scale: 2, precision: 12
            total           column: 'total',  scale: 2, precision: 14
        }

    }
    def beforeValidate() {
        if (amount != null && unitPrice != null) {
            total = (unitPrice * amount).setScale(2, RoundingMode.HALF_UP)
        }
    }
    def beforeInsert() { beforeValidate() }
    def beforeUpdate() { beforeValidate() }
}
