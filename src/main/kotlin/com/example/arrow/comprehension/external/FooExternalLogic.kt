package com.example.arrow.comprehension.external

import arrow.core.Either
import org.springframework.stereotype.Component

@Component
class FooExternalLogic {

    fun findById(id: String): Either<Error, FooExternal> = Either.Right(FooExternal(id, "EXTERNAL"))
}