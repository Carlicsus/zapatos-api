package com.ccrz.shoppingCart

import com.ccrz.products.Product
import java.math.RoundingMode

class ProductsShoppingCart implements Serializable {

    ShoppingCart shoppingCart
    Product product

    Integer amount
    BigDecimal unitPrice
    BigDecimal subTotal

    static belongsTo = [shoppingCart: ShoppingCart, product: Product]

    static constraints = {
        shoppingCart nullable: false
        product      nullable: false
        amount       nullable: false, min: 1
        unitPrice    nullable: false, min: 0.00G, scale: 2
        subTotal     nullable: false, min: 0.00G
    }

    static mapping = {
        table 'tbd_products_shopping_cart'
        version false

        // PK compuesta
        id composite: ['shoppingCart', 'product']

        columns {
            shoppingCart column: 'uuid_shopping_cart' 
            product      column: 'uuid_product'  

            amount    column: 'amount'
            unitPrice column: 'unit_price', scale: 2, precision: 12
            subTotal  column: 'sub_total',  scale: 2, precision: 14
        }
    }

    def beforeValidate() {
        if (amount != null && unitPrice != null) {
            subTotal = (unitPrice * amount).setScale(2, RoundingMode.HALF_UP)
        }
    }
    def beforeInsert() { beforeValidate() }
    def beforeUpdate() { beforeValidate() }
}
