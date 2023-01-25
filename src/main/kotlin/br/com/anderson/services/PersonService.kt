package br.com.anderson.services

import br.com.anderson.model.Person
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger
import org.springframework.stereotype.Service

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person {
        logger.info("Finding one person!")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Teste"
        person.lastName = "do Teste"
        person.address = "Rua do Teste"
        person.gender = "Male"

        return person
    }

    fun findAll(): List<Person> {
        logger.info("Finding all records!")

        val persons: MutableList<Person> = ArrayList()

        for (i in 0..7) {
            val person = mockPerson(i)
            persons.add(person)
        }

        return persons
    }

    private fun mockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person Name $i"
        person.lastName = "Las Name $i"
        person.address = "Some Address in Somewhere $i"
        person.gender = "Male"

        return person
    }
}