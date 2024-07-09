package com.angellira.gabrielaPP.models

import java.sql.Date


data class User(
    var nameUser: String = "",
    var emailUser: String = "",
    var passwordUser: String = "",
    var dateOfBirth: Date = "11/11/2004"
) {
    fun setAttributes(name: String , email: String, password: String){
        this.nameUser = name
        this.emailUser = email
        this.passwordUser = password
    }
}
