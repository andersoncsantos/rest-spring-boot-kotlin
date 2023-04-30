package br.com.anderson.services

import br.com.anderson.dto.PersonDtoVersion01
import br.com.anderson.dto.PersonDtoVersion02
import br.com.anderson.exceptions.ResourceNotFoundException
import br.com.anderson.mapper.PersonMapperVersion01Impl
import br.com.anderson.mapper.PersonMapperVersion02Impl
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

    fun findAllVersion01(): List<PersonDtoVersion01> {
        logger.info("Finding all records!")
        return PersonMapperVersion01Impl().toDtoList(repository.findAll())
    }

    fun findAllVersion02(): List<PersonDtoVersion02> {
        logger.info("Finding all records!")
        return PersonMapperVersion02Impl().toDtoList(repository.findAll())
    }

    fun findByIdVersion01(id: Long): PersonDtoVersion01 {
        logger.info("Finding one person!")
        val person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for id: $id") }

        return PersonMapperVersion01Impl().toDto(person)
    }

    fun findByIdVersion02(id: Long): PersonDtoVersion02 {
        logger.info("Finding one person!")
        val person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for id: $id") }

        return PersonMapperVersion02Impl().toDto(person)
    }

    fun createVersion01(personDtoVersion01: PersonDtoVersion01): PersonDtoVersion01 {
        logger.info("Creating one person with name: ${personDtoVersion01.firstName}")
        val entity: Person = PersonMapperVersion01Impl().toEntity(personDtoVersion01)
        return PersonMapperVersion01Impl().toDto(repository.save(entity))
    }

    fun createVersion02(personDtoVersion02: PersonDtoVersion02): PersonDtoVersion02 {
        logger.info("Creating one person with name: ${personDtoVersion02.firstName}")
        val entity: Person = PersonMapperVersion02Impl().toEntity(personDtoVersion02)
        return PersonMapperVersion02Impl().toDto(repository.save(entity))
    }

    fun updateVersion01(personDtoVersion01: PersonDtoVersion01): PersonDtoVersion01 {
        logger.info("Updating one person with id: ${personDtoVersion01.id}")
        val entity = repository.findById(personDtoVersion01.id)
            .orElseThrow { ResourceNotFoundException("No records found for id: ${personDtoVersion01.id}") }

        entity.firstName = personDtoVersion01.firstName
        entity.lastName = personDtoVersion01.lastName
        entity.address = personDtoVersion01.address
        entity.gender = personDtoVersion01.gender

        return PersonMapperVersion01Impl().toDto(repository.save(entity))
    }

    fun updateVersion02(personDtoVersion02: PersonDtoVersion02): PersonDtoVersion02 {
        logger.info("Updating one person with id: ${personDtoVersion02.id}")
        val entity = repository.findById(personDtoVersion02.id)
            .orElseThrow { ResourceNotFoundException("No records found for id: ${personDtoVersion02.id}") }

        entity.firstName = personDtoVersion02.firstName
        entity.lastName = personDtoVersion02.lastName
        entity.address = personDtoVersion02.address
        entity.gender = personDtoVersion02.gender

        return PersonMapperVersion02Impl().toDto(repository.save(entity))
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with id: $id")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for id: $id") }
        repository.delete(entity)
    }
}