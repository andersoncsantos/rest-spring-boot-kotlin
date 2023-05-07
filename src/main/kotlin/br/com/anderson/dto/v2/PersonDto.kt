package br.com.anderson.dto.v2

import java.time.ZonedDateTime

data class PersonDto(

    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = "",
    var birthDate: ZonedDateTime? = null
)
