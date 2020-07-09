package com.sarinawhite

import io.vertx.core.Vertx
import io.vertx.core.VertxOptions
import java.util.concurrent.TimeUnit

fun main() {
    val options = VertxOptions()
    options.blockedThreadCheckInterval = 10
    options.blockedThreadCheckIntervalUnit = TimeUnit.SECONDS
    val vertx: Vertx = Vertx.vertx(options)
    vertx.deployVerticle("com.sarinawhite.api.Server")
}