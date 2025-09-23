package com.ccrz.products

class Product {
    String id = UUID.randomUUID().toString().replaceAll('\\-','') // usa 'id' como PK
    String name
    String slug
    String description
    String brand
    Integer amount
    Map<String, Object> variants
    Integer basePrice
    Boolean status = true
    Date dateCreated

    static constraints = {
        name blank:false, maxSize: 255
        brand maxSize: 100
        description nullable: true, maxSize: 1000
        variants nullable: true
        slug blank: false, unique: true
    }

    static mapping = {
        table 'tbb_product'
        version false
        id column: 'uuid', generator: 'assigned'  // <- PK = uuid
        // elimina el campo 'uuid' extra; ahora 'id' ES el uuid
        description type: 'text'
        // si quieres índice adicional sobre slug:
        slug index: 'slug_idx'
    }

}
