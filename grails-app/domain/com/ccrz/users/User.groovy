package com.ccrz.users

class User {
    String uuid = UUID.randomUUID().toString().replaceAll("-", "")
    String name
    String last_name
    String email
    String password
    Date birthday
    String phone_number
    String status = "active"
    Date created_at
    Date update_at

    static belongsTo = [adrees: Address]

    static constraints = {
    name        (blank:false,  size:3..30, matches:"[a-zA-Z1-9_]+")
    uuid        (maxSize: 36, unique: true)
    last_name   (blank:false,  size:3..30, matches:"[a-zA-Z1-9_]+")
    email       (email:true, blank: false)
    password    (password:true, blank:false,  size:3..30, matches:"[a-aA-Z1-9_]+")
    phone_number (nullable: true, blank:false size:10)
    status       inList:['active', 'inactive']
    }

    static mapping = {
        table name:"tbb_User"
        id name: 'uuid', generator: 'assigned'   
        version false
        //status sqlType: "Enum('active','inactive')" comment: 'En este campo se determina el estatus de la cuenta del usuario'
    }
}