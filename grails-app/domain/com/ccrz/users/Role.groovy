package com.ccrz.users

class Role {
    String rol
    String status = "active"
    static constraints = {
        status inList : ["active", "inactive"]
    }
}
