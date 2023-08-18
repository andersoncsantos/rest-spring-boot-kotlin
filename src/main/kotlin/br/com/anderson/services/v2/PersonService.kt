package br.com.anderson.services.v2

import br.com.anderson.controller.v2.PersonController
import br.com.anderson.dto.v2.PersonDto
import br.com.anderson.exceptions.RequiredObjectIsNullException
import br.com.anderson.exceptions.ResourceNotFoundException
import br.com.anderson.mapper.v2.PersonMapperImpl
import br.com.anderson.model.Person
import br.com.anderson.repository.PersonRepository
import java.util.logging.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
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
        val personDtos = PersonMapperImpl().toDtoList(repository.findAll())

        for (person in personDtos) {
            val withSelfRel = linkTo(PersonController::class.java).slash(person.id).withSelfRel()
            person.add(withSelfRel)
        }

        return personDtos
    }

    fun findById(id: Long): PersonDto {
        logger.info("Finding one person!")
        val person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for id: $id") }
        val withSelfRel = linkTo(PersonController::class.java).slash(person.id).withSelfRel()

        return PersonMapperImpl().toDto(person).add(withSelfRel)
    }

    fun create(personDto: PersonDto?): PersonDto {
        if (personDto == null) throw RequiredObjectIsNullException()
        logger.info("Creating one person with name: ${personDto.firstName}")
        val person: Person = PersonMapperImpl().toEntity(personDto)
        val withSelfRel = linkTo(PersonController::class.java).slash(person.id).withSelfRel()

        return PersonMapperImpl().toDto(repository.save(person)).add(withSelfRel)
    }

    fun update(personDto: PersonDto?): PersonDto {
        if (personDto == null) throw RequiredObjectIsNullException()
        logger.info("Updating one person with id: ${personDto.id}")
        val person = repository.findById(personDto.id)
            .orElseThrow { ResourceNotFoundException("No records found for id: ${personDto.id}") }

        person.firstName = personDto.firstName
        person.lastName = personDto.lastName
        person.address = personDto.address
        person.gender = personDto.gender

        val withSelfRel = linkTo(PersonController::class.java).slash(person.id).withSelfRel()

        return PersonMapperImpl().toDto(repository.save(person)).add(withSelfRel)
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with id: $id")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for id: $id") }
        repository.delete(entity)
    }
}