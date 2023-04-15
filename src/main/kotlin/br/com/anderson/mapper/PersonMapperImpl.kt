package br.com.anderson.mapper

import br.com.anderson.dto.PersonDtoV1
import br.com.anderson.dto.PersonDtoV2
import br.com.anderson.model.Person
import java.time.ZoneId
import java.time.ZonedDateTime

class PersonMapperImpl: PersonMapper {

    override fun toDtoV1(person: Person): PersonDtoV1 {
        return PersonDtoV1(
            id = person.id,
            firstName = person.firstName,
            lastName = person.lastName,
            address = person.address,
            gender = person.gender
        )
    }

    override fun toDtoV2(person: Person): PersonDtoV2 {
        return PersonDtoV2(
            id = person.id,
            firstName = person.firstName,
            lastName = person.lastName,
            address = person.address,
            gender = person.gender,
            birthDate = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"))
        )
    }

    override fun toDtoListV1(origin: List<Person>): ArrayList<PersonDtoV1> {
        val destinationObjects: ArrayList<PersonDtoV1> = ArrayList()

        for (o in origin) {
            destinationObjects.add(toDtoV1(o))
        }

        return destinationObjects
    }

    override fun toDtoListV2(origin: List<Person>): ArrayList<PersonDtoV2> {
        val destinationObjects: ArrayList<PersonDtoV2> = ArrayList()

        for (o in origin) {
            destinationObjects.add(toDtoV2(o))
        }

        return destinationObjects
    }

    override fun toEntityV1(personDtoV1: PersonDtoV1): Person {
        return Person(
            id = personDtoV1.id,
            firstName = personDtoV1.firstName,
            lastName = personDtoV1.lastName,
            address = personDtoV1.address,
            gender = personDtoV1.gender
        )
    }

    override fun toEntityV2(personDtoV2: PersonDtoV2): Person {
        return Person(
            id = personDtoV2.id,
            firstName = personDtoV2.firstName,
            lastName = personDtoV2.lastName,
            address = personDtoV2.address,
            gender = personDtoV2.gender,
        )
    }

    override fun toEntityList(origin: List<PersonDtoV1>): ArrayList<Person> {
        val destinationObjects: ArrayList<Person> = ArrayList()

        for (o in origin) {
            destinationObjects.add(toEntityV1(o))
        }

        return destinationObjects
    }
}
