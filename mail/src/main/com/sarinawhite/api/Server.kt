package com.sarinawhite.api

import com.sarinawhite.model.OrderStatus
import io.vertx.core.AbstractVerticle
import io.vertx.core.AsyncResult
import io.vertx.core.Promise
import io.vertx.core.http.HttpServer
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.BodyHandler
import java.lang.IllegalArgumentException
import java.time.LocalDate

private const val PORT: Int = 1234

class Server : AbstractVerticle() {
    override fun start(promise: Promise<Void>) {
        val router: Router = Router.router(vertx)
        router.route().handler(BodyHandler.create())

        router.post("/orderStatus").handler { r: RoutingContext -> this.handlePostOrderStatus(r) }
        vertx.createHttpServer()
                .requestHandler(router)
                .listen(PORT) { result: AsyncResult<HttpServer?> ->
                    if (result.succeeded()) {
                        promise.complete()
                    } else {
                        promise.fail(result.cause())
                    }
                }
    }

    private fun handlePostOrderStatus(r: RoutingContext) {
        r.response().end("Order status received")
        val bodyStr = r.bodyAsString.trim().toUpperCase()
        val orderStatus: OrderStatus;
        try {
            orderStatus = OrderStatus.valueOf(bodyStr)
        } catch (e: IllegalArgumentException) {
            println("Unknown order status: $bodyStr");
            return
        }
        when(orderStatus) {
            OrderStatus.FAILURE -> println("FAILURE. Reason: Unknown")
            OrderStatus.SUCCESS -> println("SUCCESS. Estimate delivery = ${LocalDate.now().plusDays(5)}");
        }
    }
}