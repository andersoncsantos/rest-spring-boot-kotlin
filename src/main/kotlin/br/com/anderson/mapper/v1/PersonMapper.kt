package br.com.anderson.mapper.v1

import br.com.anderson.dto.v1.PersonDto
import br.com.anderson.model.Person

interface PersonMapper {

    fun toDto(person: Person): PersonDto
    fun toDtoList(origin: List<Person>): ArrayList<PersonDto>
    fun toEntity(personDto: PersonDto): Person
    fun toEntityList(origin: List<PersonDto>): ArrayList<Person>
}