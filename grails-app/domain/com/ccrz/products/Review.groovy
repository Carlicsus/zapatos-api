package com.ccrz.products

class Review {

    String uuid = UUID.randomUUID().toString().replaceAll("\\-", "")
    String title
    String content
    Boolean status = true
    String summary
    Date dateCreated

    static constraints = {
        title blank: false, maxSize: 255
        content blank: false, maxSize: 1000
        summary blank: false, maxSize: 500
    }
    static mapping = {
        version false
        table name: 'tbb_review'
        uuid index: 'uuid_idx'
        title index: 'title_idx'
    }
}
