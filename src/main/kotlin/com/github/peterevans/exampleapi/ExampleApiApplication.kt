package com.github.peterevans.exampleapi

import com.github.peterevans.exampleapi.health.TemplateHealthCheck
import com.github.peterevans.exampleapi.resources.HelloWorldResource
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class ExampleApiApplication() : Application<ExampleApiConfiguration>() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ExampleApiApplication().run(*args)
        }
    }

    override fun run(configuration: ExampleApiConfiguration, environment: Environment) {
        val resource =  HelloWorldResource(configuration.template, configuration.defaultName)
        environment.jersey().register(resource)

        val templateHealthCheck = TemplateHealthCheck(configuration.template)
        environment.healthChecks().register("template", templateHealthCheck)
    }

    override fun initialize(bootstrap: Bootstrap<ExampleApiConfiguration>?) {
        // Do nothing
    }
}
