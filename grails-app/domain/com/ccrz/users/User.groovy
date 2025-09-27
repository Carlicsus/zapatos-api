package com.ccrz.users

class User {
    String uuid = UUID.randomUUID().toString().replaceAll("-", "")
    String name
    String lastName
    String email
    String password
    Date birthday
    String phoneNumber
    String status = "active"
    Date createdAt
    Date updateAt

    static belongsTo = [adrees: Address]

    static constraints = {
    name blank:false, maxSize:30, matches:"[a-zA-Z1-9_]+"
    uuid size: 36, unique: true
    last_name blank:false,  maxSize:30, matches:"[a-zA-Z1-9_]+"
    email email:true, blank: false
    password password:true, blank:false,  maxSize:30, matches:"[a-aA-Z1-9_]+"
    phone_number nullable: true, blank:false, size:10
    status inList:['active', 'inactive']
    }

    static mapping = {
        table name: "tbb_User"
        version false
        id name: 'uuid', generator: 'assigned'
        lastName column: 'last_name' 
        phoneNumber column: 'phone_number' 
        createdAt column: 'created_at'
        updateAt column: 'update_at'
    }
}