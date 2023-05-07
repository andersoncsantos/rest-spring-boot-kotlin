package br.com.anderson.mapper.v2

import br.com.anderson.dto.v2.PersonDto
import br.com.anderson.model.Person
import java.time.ZoneId
import java.time.ZonedDateTime

class PersonMapperImpl: PersonMapper {

    override fun toDto(person: Person): PersonDto {
        return PersonDto(
            id = person.id,
            firstName = person.firstName,
            lastName = person.lastName,
            address = person.address,
            gender = person.gender,
            birthDate = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"))
        )
    }

    override fun toDtoList(origin: List<Person>): ArrayList<PersonDto> {
        val destinationObjects: ArrayList<PersonDto> = ArrayList()

        for (o in origin) {
            destinationObjects.add(toDto(o))
        }

        return destinationObjects
    }

    override fun toEntity(personDto: PersonDto): Person {
        return Person(
            id = personDto.id,
            firstName = personDto.firstName,
            lastName = personDto.lastName,
            address = personDto.address,
            gender = personDto.gender
        )
    }

    override fun toEntityList(origin: List<PersonDto>): ArrayList<Person> {
        val destinationObjects: ArrayList<Person> = ArrayList()

        for (o in origin) {
            destinationObjects.add(toEntity(o))
        }

        return destinationObjects
    }
}
