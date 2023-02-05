package br.com.anderson.services

import br.com.anderson.exceptions.ResourceNotFoundException
import br.com.anderson.model.Person
import br.com.anderson.repository.PersonRepository
import java.util.logging.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding all records!")

        /*val persons: MutableList<Person> = ArrayList()

        for (i in 0..7) {
            val person = mockPerson(i)
            persons.add(person)
        }

        return persons*/

        return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("Finding one person!")

       /* val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Teste"
        person.lastName = "do Teste"
        person.address = "Rua do Teste"
        person.gender = "Male"

        return person*/

        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for id: $id") }
    }

    fun create(person: Person): Person {
        /*return person*/
        logger.info("Creating one person with name: ${person.firstName}")
        return repository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Updating one person with id: ${person.id}")
        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("No records found for id: ${person.id}") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        return repository.save(entity)
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with id: $id")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for id: $id") }
        repository.delete(entity)
    }

    /*private fun mockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person Name $i"
        person.lastName = "Las Name $i"
        person.address = "Some Address in Somewhere $i"
        person.gender = "Male"

        return person
    }*/
}