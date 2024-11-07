package com.ndgs.NetflixDGS.accounts.domain

data class Account(
//this is primary constructor
     val id : Int,
     val clientId : String,
     val currency : Currency,
     val balance : Float,
     val status : String

)