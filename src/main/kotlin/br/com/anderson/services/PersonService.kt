package br.com.anderson.services

import br.com.anderson.model.Person
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger
import org.springframework.stereotype.Service

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person {
        logger.info("Finding one person!")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Teste"
        person.lastName = "do Teste"
        person.address = "Rua do Teste"
        person.gender = "Male"

        return person
    }

}