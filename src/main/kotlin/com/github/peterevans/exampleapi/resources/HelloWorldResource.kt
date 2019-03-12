package com.github.peterevans.exampleapi.resources

import com.codahale.metrics.annotation.Timed
import com.github.peterevans.exampleapi.core.Saying
import com.google.common.base.Optional
import java.util.concurrent.atomic.AtomicLong
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
class HelloWorldResource(val template: String, val defaultName: String) {
    var counter = AtomicLong()

    @Timed
    @GET
    fun sayHello(@QueryParam("name") name: Optional<String>): Saying {
        val value = String.format(template, name.or(defaultName))
        return Saying(counter.incrementAndGet(), value)
    }
}
