package br.com.anderson.mapper

import br.com.anderson.dto.PersonDtoV1
import br.com.anderson.dto.PersonDtoV2
import br.com.anderson.model.Person

interface PersonMapper {

    fun toDtoV1(person: Person): PersonDtoV1
    fun toDtoV2(person: Person): PersonDtoV2
    fun toDtoListV1(origin: List<Person>): ArrayList<PersonDtoV1>
    fun toDtoListV2(origin: List<Person>): ArrayList<PersonDtoV2>
    fun toEntityV1(personDtoV1: PersonDtoV1): Person
    fun toEntityV2(personDtoV2: PersonDtoV2): Person
    fun toEntityList(origin: List<PersonDtoV1>): ArrayList<Person>
}