package com.example.arrow.comprehension

import arrow.core.Either
import arrow.core.computations.either
import com.example.arrow.comprehension.external.FooExternalLogic
import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.util.*

@Component
class FooLogic(
    private val repository: FooRepository,
    private val externalLogic: FooExternalLogic,
) {
    private val klogger = KotlinLogging.logger {}

    fun all(): List<Foo> = repository.findAll()

    fun add(foo: Foo): Either<Error, Foo> = either.eager {
        klogger.info { "Received $foo" }

        val external = externalLogic.findById(foo.external.id).bind()
        klogger.info { "Received $external" }

        val mapped = foo.with(external, UUID.randomUUID())
        klogger.info { "Mapped foo: $mapped" }

        val stored = repository.save(mapped)
        klogger.info { "Stored foo: $stored" }

        stored
    }
}