package com.ccrz.shoppingCart

import com.ccrz.products.Product
import java.math.BigDecimal
import java.math.RoundingMode

class ProductsShoppingCart implements Serializable {

    // Claves foráneas para la llave compuesta
    String uuidShoppingCart   
    String uuidProduct        

    // Atributos
    Integer amount
    BigDecimal unitPrice
    BigDecimal subTotal

    static belongsTo = [shoppingCart: ShoppingCart, product: Product]

    static constraints = {
        uuidShoppingCart nullable: false, blank: false, maxSize: 36
        uuidProduct      nullable: false, blank: false, maxSize: 36
        amount           nullable: false, min: 1
        unitPrice        nullable: false, min: 0.00G, scale: 2
        subTotal         nullable: false, min: 0.00G
    }

    static mapping = {
        table 'tbd_products_shopping_cart'
        version false

        // Creacion de la llave compuesta
        id composite: ['uuidShoppingCart', 'uuidProduct']

        columns {
            uuidShoppingCart column: 'uuid'           
            uuidProduct      column: 'uuid_product'
            amount           column: 'amount'
            unitPrice        column: 'unit_price',  scale: 2, precision: 12
            subTotal         column: 'sub_total',   scale: 2, precision: 14    
        }
    }

    // Hooks
    def beforeValidate() {
        if (amount != null && unitPrice != null) {
            subTotal = (unitPrice * amount).setScale(2, RoundingMode.HALF_UP)
        }
    }

    def beforeInsert() { beforeValidate() }
    def beforeUpdate() { beforeValidate() }
}
