package br.com.anderson.utils

import org.springframework.http.MediaType

object ContentMediaType {

    const val APPLICATION_JSON_VALUE = "application/json"
    val APPLICATION_JSON = MediaType("application", "json")

    const val APPLICATION_XML_VALUE = "application/xml"
    val APPLICATION_XML = MediaType("application", "xml")

    const val APPLICATION_YML_VALUE = "application/x-yaml"
    val APPLICATION_YML = MediaType("application", "x-yaml")
}