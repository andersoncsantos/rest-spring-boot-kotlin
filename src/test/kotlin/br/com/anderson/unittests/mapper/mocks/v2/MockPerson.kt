package br.com.anderson.unittests.mapper.mocks.v2

import br.com.anderson.dto.v2.PersonDto
import br.com.anderson.model.Person


class MockPerson {
    fun mockEntity(): Person {
        return mockEntity(0)
    }

    fun mockDTO(): PersonDto {
        return mockDTO(0)
    }

    fun mockEntityList(): ArrayList<Person> {

        val persons: ArrayList<Person> = ArrayList()

        for (i in 0..13) {
            persons.add(mockEntity(i))
        }

        return persons
    }

    fun mockDTOList(): ArrayList<PersonDto> {
        val persons: ArrayList<PersonDto> = ArrayList()
        for (i in 0..13) {
            persons.add(mockDTO(i))
        }
        return persons
    }

    fun mockEntity(number: Int): Person {

        val person = Person()

        person.address = "Address Test$number"
        person.firstName = "First Name Test$number"
        person.gender = if (number % 2 == 0) "Male" else "Female"
        person.id = number.toLong()
        person.lastName = "Last Name Test$number"

        return person
    }

    fun mockDTO(number: Int): PersonDto {

        val person = PersonDto()

        person.id = number.toLong()
        person.address = "Address Test$number"
        person.firstName = "First Name Test$number"
        person.lastName = "Last Name Test$number"
        person.gender = if (number % 2 == 0) "Male" else "Female"

        return person
    }
}