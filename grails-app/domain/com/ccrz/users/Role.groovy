package com.ccrz.users

class Role {
    String rol
    String status = "active"

    static hasMany = [userRoles: UserRole]
    static constraints = {
        status inList : ["active", "inactive"]
    }

    static mapping = {
        table name:"tbb_Role"
    }
}
