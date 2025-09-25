package com.ccrz.users

class UserRole implements Serializable {
    String uuid = UUID.randomUUID().toString().replaceAll("-", "")
    User user
    Role role
    Date created_at
    Date update_at

    static belongsTo = [user: User, role: Role]

  static constraints = {
    uuid unique:true, maxSize:36
    user nullable:false
    role nullable:false, unique:'user'  // (user, role) único
  }
  static mapping = {
    table 'tbd_User_Role'
        id name:'uuid', generator:'assigned'
        version false
        user column:'uuid_user'
        role column:'uuid_role'
  }
}
