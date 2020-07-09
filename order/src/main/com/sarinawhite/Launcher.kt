package com.sarinawhite

import com.sarinawhite.helper.OrderHandler
import com.sarinawhite.integration.mail.MailClient
import com.sarinawhite.integration.mail.OrderStatus
import com.sarinawhite.model.Order
import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.DefaultHelpFormatter
import com.xenomachina.argparser.mainBody
import io.vertx.core.Vertx

fun main(args: Array<String>) = mainBody {
    ArgParser(args, helpFormatter = DefaultHelpFormatter(DESCRIPTION)).parseInto(::OrderArgs).run {
        println("Received order = $order")
        val orderResult = OrderHandler.handleOrder(order)
        val invalidInputStrings = orderResult.second
        if (invalidInputStrings.isNotEmpty()) {
            println("ERROR: Order cannot be processed. Invalid input = ${invalidInputStrings.joinToString(", ")}")
        } else {
            val validItems = orderResult.first
            println("Total price = \$${Order(validItems).getTotalCost()}")
            val vertx: Vertx = Vertx.vertx()
            println("Attempting to send order status...")
            MailClient(vertx).sendOrderStatus(OrderStatus.SUCCESS)
        }
    }
}

private const val DESCRIPTION =
        "This application allows for the user to input a CSV of items they would like to order," +
                " and then outputs the total price."

class OrderArgs(parser: ArgParser) {
    val order by parser.storing(
            "-o", "--order",
            help = "String representing all individual items to order, comma separated. Capitalization does not matter." +
                    " | Example: \"Apple, Apple, Orange, Apple\"" +
                    " | Valid items: Apple, Orange"
    )
}