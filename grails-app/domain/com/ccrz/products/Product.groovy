package com.ccrz.products

class Product {
    String uuid = UUID.randomUUID().toString().replaceAll("\\-", "")
    String name
    String slug
    String description
    String brand
    Integer amount
    Map <String, Object> variants
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
        version false
        table name: 'tbb_product'
        description type: 'text'
        uuid index: 'uuid_idx'
        slug index: 'slug_idx'
    }

}
