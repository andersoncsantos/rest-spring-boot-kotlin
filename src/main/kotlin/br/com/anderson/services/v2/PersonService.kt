package br.com.anderson.services.v2

import br.com.anderson.dto.v2.PersonDto
import br.com.anderson.exceptions.ResourceNotFoundException
import br.com.anderson.mapper.v2.PersonMapperImpl
import br.com.anderson.model.Person
import br.com.anderson.repository.PersonRepository
import java.util.logging.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
@Component("person_service_v2")
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonDto> {
        logger.info("Finding all records!")
        return PersonMapperImpl().toDtoList(repository.findAll())
    }

    fun findById(id: Long): PersonDto {
        logger.info("Finding one person!")
        val person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for id: $id") }

        return PersonMapperImpl().toDto(person)
    }

    fun create(personDto: PersonDto): PersonDto {
        logger.info("Creating one person with name: ${personDto.firstName}")
        val entity: Person = PersonMapperImpl().toEntity(personDto)
        return PersonMapperImpl().toDto(repository.save(entity))
    }

    fun update(personDto: PersonDto): PersonDto {
        logger.info("Updating one person with id: ${personDto.id}")
        val entity = repository.findById(personDto.id)
            .orElseThrow { ResourceNotFoundException("No records found for id: ${personDto.id}") }

        entity.firstName = personDto.firstName
        entity.lastName = personDto.lastName
        entity.address = personDto.address
        entity.gender = personDto.gender

        return PersonMapperImpl().toDto(repository.save(entity))
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with id: $id")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for id: $id") }
        repository.delete(entity)
    }
}