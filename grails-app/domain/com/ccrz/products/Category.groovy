package com.ccrz.products

class Category {

    String uuid = UUID.randomUUID().toString().replaceAll("\\-", "")
    String name
    String slug
    Integer higher_category
    Boolean status = true
    Date dateCreated

    static constraints = {
        name blank:false, maxSize: 255
        slug blank: false, unique: true
        higher_category nullable: true
    }
    static mapping = {
        version false
        table name: 'tbb_category'
        uuid index: 'uuid_idx'
        slug index: 'slug_idx'
    }


}
