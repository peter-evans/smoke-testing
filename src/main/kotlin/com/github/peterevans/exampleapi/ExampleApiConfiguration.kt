package com.github.peterevans.exampleapi

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration

class ExampleApiConfiguration : Configuration() {
    @JsonProperty("template")
    public var template: String = ""

    @JsonProperty("defaultName")
    public var defaultName: String = "Stranger"
}
