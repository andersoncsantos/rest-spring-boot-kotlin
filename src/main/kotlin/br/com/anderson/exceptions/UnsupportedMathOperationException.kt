package br.com.anderson.exceptions

import java.lang.RuntimeException

class UnsupportedMathOperationException(exception: String?): RuntimeException(exception)