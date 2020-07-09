package com.sarinawhite.integration.mail

import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer
import io.vertx.ext.web.client.WebClient
import io.vertx.kotlin.ext.web.client.sendBufferAwait
import kotlin.system.exitProcess

class MailClient(private val vertx: Vertx) {

    private val client: WebClient = WebClient.create(vertx)

    fun sendOrderStatus(orderStatus: OrderStatus) {
        client.post(1234, "localhost", "/orderStatus")
                .sendBuffer(Buffer.buffer(orderStatus.toString())) { ar ->
                    if (ar.succeeded()) {
                        println("Sending Order Status Succeeded")
                    } else {
                        println("Sending Order Status Failed")
                    }
                    exitProcess(0)
                }
    }

}