package br.com.anderson.controller.v2

import br.com.anderson.dto.v2.PersonDto
import br.com.anderson.services.v2.PersonService
import br.com.anderson.utils.ContentMediaType
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person/v2")
@Component("person_controller_v2")
class PersonController {

    @Autowired
    private lateinit var service: PersonService

    @GetMapping(
        produces = [ContentMediaType.APPLICATION_JSON_VALUE, ContentMediaType.APPLICATION_XML_VALUE, ContentMediaType.APPLICATION_YML_VALUE]
    )
    fun findAll(): List<PersonDto> {
        return service.findAll()
    }

    @GetMapping(
        value = ["/{id}"],
        produces = [ContentMediaType.APPLICATION_JSON_VALUE, ContentMediaType.APPLICATION_XML_VALUE, ContentMediaType.APPLICATION_YML_VALUE]
    )
    fun findById(@PathVariable(value = "id") id: Long): PersonDto {
        return service.findById(id)
    }

    @PostMapping(
        produces = [ContentMediaType.APPLICATION_JSON_VALUE, ContentMediaType.APPLICATION_XML_VALUE, ContentMediaType.APPLICATION_YML_VALUE],
        consumes = [ContentMediaType.APPLICATION_JSON_VALUE, ContentMediaType.APPLICATION_XML_VALUE, ContentMediaType.APPLICATION_YML_VALUE]
    )
    fun create(@RequestBody personDto: PersonDto): PersonDto {
        return service.create(personDto)
    }

    @PutMapping(
        produces = [ContentMediaType.APPLICATION_JSON_VALUE, ContentMediaType.APPLICATION_XML_VALUE, ContentMediaType.APPLICATION_YML_VALUE],
        consumes = [ContentMediaType.APPLICATION_JSON_VALUE, ContentMediaType.APPLICATION_XML_VALUE, ContentMediaType.APPLICATION_YML_VALUE]
    )
    fun update(@RequestBody personDto: PersonDto): PersonDto {
        return service.update(personDto)
    }

    @DeleteMapping(
        value = ["/{id}"],
        produces = [ContentMediaType.APPLICATION_JSON_VALUE, ContentMediaType.APPLICATION_XML_VALUE, ContentMediaType.APPLICATION_YML_VALUE]
    )
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }

}