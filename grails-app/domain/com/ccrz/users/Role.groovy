package com.ccrz.users

class Role {
    String uuid = UUID.randomUUID().toString().replaceAll("-", "")
    
    String rol
    String status = "active"

    static hasMany = [userRoles: UserRole]
    static constraints = {
        status inList : ["active", "inactive"]
    }

    static mapping = {
        table name:"tbb_Role"
        id name: 'uuid', generator: 'assigned'
        version false
    }
}
