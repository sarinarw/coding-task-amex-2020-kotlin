package com.sarinawhite

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.DefaultHelpFormatter
import com.xenomachina.argparser.mainBody
import com.sarinawhite.helper.OrderHandler
import com.sarinawhite.model.Order

fun main(args: Array<String>) = mainBody {
    ArgParser(args, helpFormatter = DefaultHelpFormatter(DESCRIPTION)).parseInto(::OrderArgs).run {
        println("Received order = $order")
        val orderResult = OrderHandler.handleOrder(order)
        val invalidInputStrings = orderResult.second
        val outputMessage = if (invalidInputStrings.isNotEmpty()) {
            "ERROR: Order cannot be processed. Invalid input = ${invalidInputStrings.joinToString(", ")}"
        } else {
            val validItems = orderResult.first
            "Total price = \$${Order(validItems).getTotalCost()}"
        }

        println(outputMessage)
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