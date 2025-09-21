package com.ccrz.products

class ProductBrand {

    String uuid = UUID.randomUUID().toString().replaceAll("\\-", "")
    String name
    Date dateCreated
    Boolean status = true
    double rating = 0.0

    static constraints = {
        name nullable: false, blank: false, maxSize: 255
        dateCreated nullable: false
        status nullable: false
        rating nullable: false, min: 0.0, max: 5.0
    }

    static mapping = {
        version false
        table name: 'tbc_product_brand'
        uuid index: 'uuid_idx'
        name index: 'name_idx'
    }
}
