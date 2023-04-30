package br.com.anderson.mapper

import br.com.anderson.dto.PersonDtoVersion01
import br.com.anderson.dto.PersonDtoVersion02
import br.com.anderson.model.Person
import java.time.ZoneId
import java.time.ZonedDateTime

class PersonMapperVersion01Impl: PersonMapperVersion01 {

    override fun toDto(person: Person): PersonDtoVersion01 {
        return PersonDtoVersion01(
            id = person.id,
            firstName = person.firstName,
            lastName = person.lastName,
            address = person.address,
            gender = person.gender
        )
    }

    override fun toDtoList(origin: List<Person>): ArrayList<PersonDtoVersion01> {
        val destinationObjects: ArrayList<PersonDtoVersion01> = ArrayList()

        for (o in origin) {
            destinationObjects.add(toDto(o))
        }

        return destinationObjects
    }

    override fun toEntity(personDto: PersonDtoVersion01): Person {
        return Person(
            id = personDto.id,
            firstName = personDto.firstName,
            lastName = personDto.lastName,
            address = personDto.address,
            gender = personDto.gender
        )
    }

    override fun toEntityList(origin: List<PersonDtoVersion01>): ArrayList<Person> {
        val destinationObjects: ArrayList<Person> = ArrayList()

        for (o in origin) {
            destinationObjects.add(toEntity(o))
        }

        return destinationObjects
    }
}

class PersonMapperVersion02Impl: PersonMapperVersion02 {

    override fun toDto(person: Person): PersonDtoVersion02 {
        return PersonDtoVersion02(
            id = person.id,
            firstName = person.firstName,
            lastName = person.lastName,
            address = person.address,
            gender = person.gender,
            birthDate = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"))
        )
    }

    override fun toDtoList(origin: List<Person>): ArrayList<PersonDtoVersion02> {
        val destinationObjects: ArrayList<PersonDtoVersion02> = ArrayList()

        for (o in origin) {
            destinationObjects.add(toDto(o))
        }

        return destinationObjects
    }

    override fun toEntity(personDto: PersonDtoVersion02): Person {
        return Person(
            id = personDto.id,
            firstName = personDto.firstName,
            lastName = personDto.lastName,
            address = personDto.address,
            gender = personDto.gender
        )
    }

    override fun toEntityList(origin: List<PersonDtoVersion02>): ArrayList<Person> {
        val destinationObjects: ArrayList<Person> = ArrayList()

        for (o in origin) {
            destinationObjects.add(toEntity(o))
        }

        return destinationObjects
    }
}
