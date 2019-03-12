package com.github.peterevans.exampleapi.health

import com.codahale.metrics.health.HealthCheck

class TemplateHealthCheck(val template: String) : HealthCheck() {
    override fun check() : Result {
        val saying = java.lang.String.format(template, "TEST")
        if (!saying.contains("TEST"))
            return Result.unhealthy("template doesn't include a name")
        return Result.healthy()
    }
}
