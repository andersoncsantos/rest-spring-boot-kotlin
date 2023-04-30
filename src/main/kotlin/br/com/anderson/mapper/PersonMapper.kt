package br.com.anderson.mapper

import br.com.anderson.dto.PersonDtoVersion01
import br.com.anderson.dto.PersonDtoVersion02
import br.com.anderson.model.Person

interface PersonMapperVersion01 {

    fun toDto(person: Person): PersonDtoVersion01
    fun toDtoList(origin: List<Person>): ArrayList<PersonDtoVersion01>
    fun toEntity(personDto: PersonDtoVersion01): Person
    fun toEntityList(origin: List<PersonDtoVersion01>): ArrayList<Person>
}

interface PersonMapperVersion02 {

    fun toDto(person: Person): PersonDtoVersion02
    fun toDtoList(origin: List<Person>): ArrayList<PersonDtoVersion02>
    fun toEntity(personDto: PersonDtoVersion02): Person
    fun toEntityList(origin: List<PersonDtoVersion02>): ArrayList<Person>
}