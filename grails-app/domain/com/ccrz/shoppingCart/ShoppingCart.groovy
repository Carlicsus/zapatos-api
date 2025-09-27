package com.ccrz.shoppingCart
import com.ccrz.shoppingCart.ProductsShoppingCart  

class ShoppingCart implements Serializable {
    // PK
    String uuid = UUID.randomUUID().toString().replaceAll('\\-','')
    // FK al usuario
    String uuid_user

    Boolean status = true
    Date lastUpdated

    static hasMany = [items: ProductsShoppingCart]  

    static constraints = {
        uuid       nullable: false, blank: false, maxSize: 36
        uuid_user  nullable: false, blank: false, maxSize: 36
        status     nullable: false
        lastUpdated nullable: true  
    }

    static mapping = {
        table 'tbb_shoppingCart'
        version false

        id name: 'uuid', column: 'uuid', generator: 'assigned'

        columns {
            uuid_user   column: 'uuid_user'
            status      column: 'status'
            lastUpdated column: 'updated_at'
        }
    }
}
