package com.example.arrow.comprehension

import org.springframework.data.mongodb.repository.MongoRepository

interface FooRepository: MongoRepository<Foo, String>