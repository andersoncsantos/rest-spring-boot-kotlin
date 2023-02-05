package br.com.anderson.exceptions.handler

import br.com.anderson.exceptions.ExceptionResponse
import br.com.anderson.exceptions.ResourceNotFoundException
import java.util.Date
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
@RestController
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(exception: Exception, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(Date(), exception.message, request.getDescription(false))
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleBadRequestExceptions(exception: Exception, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(Date(), exception.message, request.getDescription(false))
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND)
    }

}