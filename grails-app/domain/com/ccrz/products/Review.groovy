package com.ccrz.products

class Review {

    String uuid = UUID.randomUUID().toString().replaceAll("\\-", "")
    String title
    String content
    String status = "active"
    String summary
    Date dateCreated

    static belongsTo = [product: Product]

    static constraints = {
        status inList: ["active", "inactive"]
        title blank: false, maxSize: 255
        content blank: false, maxSize: 1000
        summary blank: false, maxSize: 500
    }
    static mapping = {
        status sqlType: "Enum('active','inactive')"
        version false
        table name: 'tbb_review'
        uuid index: 'uuid_idx'
        title index: 'title_idx'
    }
}
