package br.com.anderson.services

import br.com.anderson.dto.PersonDTO
import br.com.anderson.exceptions.ResourceNotFoundException
import br.com.anderson.mapper.DozerMapper
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

    fun findAll(): List<PersonDTO> {
        logger.info("Finding all records!")
        return DozerMapper.parseListObjects(repository.findAll(), PersonDTO::class.java)
    }

    fun findById(id: Long): PersonDTO {
        logger.info("Finding one person!")
        val person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for id: $id") }

        return DozerMapper.parseObject(person, PersonDTO::class.java)
    }

    fun create(personDTO: PersonDTO): PersonDTO {
        logger.info("Creating one person with name: ${personDTO.firstName}")
        val entity: Person = DozerMapper.parseObject(personDTO, Person::class.java)
        return DozerMapper.parseObject(repository.save(entity), PersonDTO::class.java)
    }

    fun update(personDTO: PersonDTO): PersonDTO {
        logger.info("Updating one person with id: ${personDTO.id}")
        val entity = repository.findById(personDTO.id)
            .orElseThrow { ResourceNotFoundException("No records found for id: ${personDTO.id}") }

        entity.firstName = personDTO.firstName
        entity.lastName = personDTO.lastName
        entity.address = personDTO.address
        entity.gender = personDTO.gender

        return DozerMapper.parseObject(repository.save(entity), PersonDTO::class.java)
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with id: $id")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for id: $id") }
        repository.delete(entity)
    }
}