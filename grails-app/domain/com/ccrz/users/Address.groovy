package com.ccrz.users

class Address {
    String uuid = UUID.randomUUID().toString().replaceAll("-", "")
    User userId
    String alias
    String street
    String outerNumber
    String innerNumber
    String block
    String city
    String state
    String zipCode
    String country

    static constraints = {
        alias       (unique:true, maxSize:22)
        street      (unique:true, nullable:false)
        outerNumber ()
        innerNumber ()
        block       (nullable:true, maxSize:120)
        city        (nullable:true)
        state       (nullable:true)
        zipCode     (nullable:true)
        country     (nullable:true)
    }

    static mapping = {
        table name:"tbb_Adrees"
        id name: 'uuid', generator: 'assigned'
        version false

        columns {
            userId column: "uuid_user"
        }
    }
}
