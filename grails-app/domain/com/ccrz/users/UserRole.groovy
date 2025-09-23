package com.ccrz.users

class UserRole {
    Date created_at
    Date update_at

    static belongsTo = [user: User, role: Role]

  static constraints = {

  }
  static mapping = {
    table name:"tbd_User_Role"
    version false
  }
}
