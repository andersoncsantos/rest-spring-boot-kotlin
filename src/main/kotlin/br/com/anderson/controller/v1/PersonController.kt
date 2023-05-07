package br.com.anderson.controller.v1

import br.com.anderson.dto.v1.PersonDto
import br.com.anderson.services.v1.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
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
@RequestMapping("/person/v1")
@Component("person_controller_v1")
class PersonController {

    @Autowired
    private lateinit var service: PersonService

    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findAllVersion01(): List<PersonDto> {
        return service.findAll()
    }

    @GetMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findByIdVersion01(@PathVariable(value = "id") id: Long): PersonDto {
        return service.findById(id)
    }

    @PostMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createVersion01(@RequestBody personDto: PersonDto): PersonDto {
        return service.create(personDto)
    }

    @PutMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateVersion01(@RequestBody personDto: PersonDto): PersonDto {
        return service.update(personDto)
    }

    @DeleteMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }

}