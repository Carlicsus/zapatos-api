package com.ccrz.users

class Address {
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

    static hasMany = [user: User]

    static constraints = {
        
    }

    static mapping = {
        table name:"tbb_Adrees"
        version false
    }
}
