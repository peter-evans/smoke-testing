package com.github.peterevans.exampleapi.resources

import com.github.peterevans.exampleapi.core.Saying
import com.google.common.base.Optional
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HelloWorldResourceTest {
    @Test
    fun testSayHello() {
        val resource = HelloWorldResource("Hello, %s!", "Stranger")
        val expected = Saying(id = 1, content = "Hello, Tester!");
        assertEquals(resource.sayHello(Optional.of("Tester")), expected)
    }

    @Test
    fun testSayHelloDefault() {
        val resource = HelloWorldResource("Hello, %s!", "Stranger")
        val expected = Saying(id = 1, content = "Hello, Stranger!");
        assertEquals(resource.sayHello(Optional.absent()), expected)
    }
}
