package com.sarinawhite.model

import java.math.BigDecimal
import java.math.RoundingMode

class Order(items: List<Item>) {

    private val items: List<Item> = ArrayList(items).filterNotNull()
    private val itemToCount = items.groupingBy { item -> item }.eachCount()

    fun getTotalCost(): BigDecimal {
        return itemToCount.map { (item, count) ->
            when (item.deal) {
                Deal.NONE -> item.price.times(BigDecimal(count))
                Deal.THREE_FOR_TWO -> item.price.times(BigDecimal(count.minus(count.div(3f).toInt())))
                Deal.BOGO -> item.price.times(BigDecimal(count.div(2f).plus(0.5).toInt()))
            }
        }.fold(BigDecimal.ZERO) { totalCost, totalItemCost -> totalCost.add(totalItemCost) }
    }

    fun isInStock(): Boolean {
        return itemToCount.filter { (item, count) -> item.stock >= count }.size == itemToCount.size
    }
}