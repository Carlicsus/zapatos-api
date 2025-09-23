package com.ccrz.products

class Product {
    String uuid = UUID.randomUUID().toString().replaceAll('\\-','')
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
        uuid       nullable: false, blank: false, maxSize: 36
        name blank:false, maxSize: 255
        brand maxSize: 100
        description nullable: true, maxSize: 1000
        variants nullable: true
        slug blank: false, unique: true
    }

    static mapping = {
        table 'tbb_product'
        version false
        id name: 'uuid', column: 'uuid', generator: 'assigned'
        // elimina el campo 'uuid' extra; ahora 'id' ES el uuid
        description type: 'text'
        // si quieres índice adicional sobre slug:
        slug index: 'slug_idx'
    }

}
