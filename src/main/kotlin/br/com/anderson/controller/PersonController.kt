package br.com.anderson.controller

import br.com.anderson.dto.PersonDtoVersion01
import br.com.anderson.dto.PersonDtoVersion02
import br.com.anderson.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var service: PersonService

    @GetMapping(
        value = ["/v1"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findAllVersion01(): List<PersonDtoVersion01> {
        return service.findAllVersion01()
    }

    @GetMapping(
        value = ["/v2"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findAllVersion02(): List<PersonDtoVersion02> {
        return service.findAllVersion02()
    }

    @GetMapping(
        value = ["/v1/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findByIdVersion01(@PathVariable(value = "id") id: Long): PersonDtoVersion01 {
        return service.findByIdVersion01(id)
    }

    @GetMapping(
        value = ["/v2/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findByIdVersion02(@PathVariable(value = "id") id: Long): PersonDtoVersion02 {
        return service.findByIdVersion02(id)
    }

    @PostMapping(
        value = ["/v1"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createVersion01(@RequestBody personDto: PersonDtoVersion01): PersonDtoVersion01 {
        return service.createVersion01(personDto)
    }

    @PostMapping(
        value = ["/v2"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createVersion02(@RequestBody personDto: PersonDtoVersion02): PersonDtoVersion02 {
        return service.createVersion02(personDto)
    }

    @PutMapping(
        value = ["/v1"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateVersion01(@RequestBody personDto: PersonDtoVersion01): PersonDtoVersion01 {
        return service.updateVersion01(personDto)
    }

    @PutMapping(
        value = ["/v2"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateVersion02(@RequestBody personDto: PersonDtoVersion02): PersonDtoVersion02 {
        return service.updateVersion02(personDto)
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