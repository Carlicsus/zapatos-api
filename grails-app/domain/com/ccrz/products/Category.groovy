package com.ccrz.products

class Category {

    String uuid = UUID.randomUUID().toString().replaceAll("\\-", "")
    String name
    String slug
    Integer higher_category
    String status = "active"
    Date dateCreated

    static belongsTo = [product: Product]
    static hasMany = [products: Product]

    static constraints = {
        status inList: ["active", "inactive"]
        name blank:false, maxSize: 255
        slug blank: false, unique: true
        higher_category nullable: true
    }
    static mapping = {
        status sqlType: "Enum('active','inactive')"
        version false
        table name: 'tbb_category'
        uuid index: 'uuid_idx'
        slug index: 'slug_idx'
    }


}
