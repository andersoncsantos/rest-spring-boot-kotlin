package br.com.anderson.dto

import java.time.ZonedDateTime


data class PersonDtoV1(

    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = ""
)

data class PersonDtoV2(

    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = "",
    var birthDate: ZonedDateTime? = null
)
