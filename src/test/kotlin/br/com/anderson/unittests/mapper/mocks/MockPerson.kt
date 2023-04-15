package br.com.anderson.unittests.mapper.mocks

import br.com.anderson.dto.PersonDtoV1
import br.com.anderson.model.Person


class MockPerson {
    fun mockEntity(): Person {
        return mockEntity(0)
    }

    fun mockDTO(): PersonDtoV1 {
        return mockDTO(0)
    }

    fun mockEntityList(): ArrayList<Person> {
        val persons: ArrayList<Person> = ArrayList<Person>()
        for (i in 0..13) {
            persons.add(mockEntity(i))
        }
        return persons
    }

    fun mockDTOList(): ArrayList<PersonDtoV1> {
        val persons: ArrayList<PersonDtoV1> = ArrayList()
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

    fun mockDTO(number: Int): PersonDtoV1 {
        val person = PersonDtoV1()
        person.address = "Address Test$number"
        person.firstName = "First Name Test$number"
        person.gender = if (number % 2 == 0) "Male" else "Female"
        person.id = number.toLong()
        person.lastName = "Last Name Test$number"
        return person
    }
}