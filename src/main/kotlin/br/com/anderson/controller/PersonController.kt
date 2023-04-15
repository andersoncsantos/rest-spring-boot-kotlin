package br.com.anderson.controller

import br.com.anderson.dto.PersonDtoV1
import br.com.anderson.dto.PersonDtoV2
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
    fun findAllV1(): List<PersonDtoV1> {
        return service.findAllV1()
    }

    @GetMapping(
        value = ["/v2"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findAllV2(): List<PersonDtoV2> {
        return service.findAllV2()
    }

    @GetMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findById(@PathVariable(value = "id") id: Long): PersonDtoV1 {
        return service.findById(id)
    }

    @PostMapping(
        value = ["/v1"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createV1(@RequestBody personDtoV1: PersonDtoV1): PersonDtoV1 {
        return service.createV1(personDtoV1)
    }

    @PutMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun update(@RequestBody personDTOV1: PersonDtoV1): PersonDtoV1 {
        return service.update(personDTOV1)
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