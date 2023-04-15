package br.com.anderson.services

import br.com.anderson.dto.PersonDtoV1
import br.com.anderson.dto.PersonDtoV2
import br.com.anderson.exceptions.ResourceNotFoundException
import br.com.anderson.mapper.PersonMapperImpl
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

    fun findAllV1(): List<PersonDtoV1> {
        logger.info("Finding all records!")
        return PersonMapperImpl().toDtoListV1(repository.findAll())
    }

    fun findAllV2(): List<PersonDtoV2> {
        logger.info("Finding all records!")
        return PersonMapperImpl().toDtoListV2(repository.findAll())
    }

    fun findById(id: Long): PersonDtoV1 {
        logger.info("Finding one person!")
        val person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for id: $id") }

        return PersonMapperImpl().toDtoV1(person)
    }

    fun createV1(personDtoV1: PersonDtoV1): PersonDtoV1 {
        logger.info("Creating one person with name: ${personDtoV1.firstName}")
        val entity: Person = PersonMapperImpl().toEntityV1(personDtoV1)
        return PersonMapperImpl().toDtoV1(repository.save(entity))
    }

    fun update(personDtoV1: PersonDtoV1): PersonDtoV1 {
        logger.info("Updating one person with id: ${personDtoV1.id}")
        val entity = repository.findById(personDtoV1.id)
            .orElseThrow { ResourceNotFoundException("No records found for id: ${personDtoV1.id}") }

        entity.firstName = personDtoV1.firstName
        entity.lastName = personDtoV1.lastName
        entity.address = personDtoV1.address
        entity.gender = personDtoV1.gender

        return PersonMapperImpl().toDtoV1(repository.save(entity))
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with id: $id")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for id: $id") }
        repository.delete(entity)
    }
}