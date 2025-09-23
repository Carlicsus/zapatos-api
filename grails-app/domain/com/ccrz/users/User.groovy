package com.ccrz.users

class User {

    String name
    String last_name
    String email
    String password
    Date birthday
    String phone_number
    String status = "active"
    Date created_at
    Date update_at

    static hasMany = [userRoles: UserRole]

    static constraints = {
    name (blank:false,  size:3..30, matches:"[a-zA-Z1-9_]+")
    last_name (blank:false,  size:3..30, matches:"[a-zA-Z1-9_]+")
    email (email:true, blank: false, )
    password (password:true, blank:false,  size:3..30, matches:"[a-aA-Z1-9_]+")
    phone_number (nullable: true)
    status inList:['active', 'inactive']
    }

    static mapping = {
        table name:"tbb_User"

        //status sqlType: "Enum('active','inactive')" comment: 'En este campo se determina el estatus de la cuenta del usuario'
    }
}