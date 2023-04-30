package br.com.anderson.unittests.mapper.mocks

import br.com.anderson.dto.PersonDtoVersion01
import br.com.anderson.model.Person


class MockPerson {
    fun mockEntity(): Person {
        return mockEntity(0)
    }

    fun mockDTO(): PersonDtoVersion01 {
        return mockDTO(0)
    }

    fun mockEntityList(): ArrayList<Person> {
        val persons: ArrayList<Person> = ArrayList<Person>()
        for (i in 0..13) {
            persons.add(mockEntity(i))
        }
        return persons
    }

    fun mockDTOList(): ArrayList<PersonDtoVersion01> {
        val persons: ArrayList<PersonDtoVersion01> = ArrayList()
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

    fun mockDTO(number: Int): PersonDtoVersion01 {
        val person = PersonDtoVersion01()
        person.address = "Address Test$number"
        person.firstName = "First Name Test$number"
        person.gender = if (number % 2 == 0) "Male" else "Female"
        person.id = number.toLong()
        person.lastName = "Last Name Test$number"
        return person
    }
}