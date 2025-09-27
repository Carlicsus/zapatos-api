package com.ccrz.products
import com.ccrz.shoppingCart.ProductsShoppingCart  

class Product {
    String uuid = UUID.randomUUID().toString().replaceAll('\\-','')
    String name
    String slug
    String description
    String brand
    Integer amount
    Map<String, Object> variants
    Integer basePrice
    String status = "active"
    Date dateCreated

    static hasMany = [cartItems: ProductsShoppingCart]  // relación inversa
    static hasMany = [categories: Category, reviews: Review]
    static belongsTo = [category: Category, brandObj: Brand]


    static constraints = {
        status inList: ["active", "inactive"]
        uuid nullable: false, blank: false, maxSize: 36
        name blank:false, maxSize: 255
        brand maxSize: 100
        description nullable: true, maxSize: 1000
        variants nullable: true
        slug blank: false, unique: true
    }

    static mapping = {
        table 'tbb_product'
        status sqlType: "Enum('active','inactive')"
        version false
        id name: 'uuid', column: 'uuid', generator: 'assigned'
        // elimina el campo 'uuid' extra; ahora 'id' ES el uuid
        description type: 'text'
        // si quieres índice adicional sobre slug:
        slug index: 'slug_idx'
    }

}
