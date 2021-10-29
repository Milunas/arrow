package com.example.arrow.comprehension

import arrow.core.getOrHandle
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class FooController(
    private val fooLogic: FooLogic,
) {

    @GetMapping
    fun all(): ResponseEntity<List<Foo>> = ResponseEntity.ok(fooLogic.all())

    @PostMapping
    fun add(@RequestBody foo: Foo): ResponseEntity<*> = fooLogic.add(foo)
        .map { ResponseEntity.status(HttpStatus.CREATED).body(it) }
        .getOrHandle { ResponseEntity.status(HttpStatus.BAD_REQUEST).body(it) }
}