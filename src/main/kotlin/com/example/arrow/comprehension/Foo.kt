package com.example.arrow.comprehension

import com.example.arrow.comprehension.external.FooExternal
import java.util.*

data class Foo(
    val external: OtherFoo,
    val name: String,
    val uuid: UUID?,
) {
    fun with(external: FooExternal, uuid: UUID): Foo = this.copy(external = OtherFoo(external.id, external.name), uuid = uuid)
}

data class OtherFoo(val id: String, val externalName: String?)