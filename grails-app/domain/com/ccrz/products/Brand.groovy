package com.ccrz.products

class Brand {
    String name
    String origin
    String description
    String uuid = UUID.randomUUID().toString().replaceAll("\\-", "")
    Boolean status = true
    Date dateCreated

    static constraints = {
        name nullable: false, blank: false, maxSize: 255
        origin nullable: false, blank: false, maxSize: 255
        description nullable: true, maxSize: 1000
    }

    static mapping = {
        table name: 'tbc_brand'
        version false
        uuid index: 'uuid_idx'
        name index: 'name_idx'
    }
}
