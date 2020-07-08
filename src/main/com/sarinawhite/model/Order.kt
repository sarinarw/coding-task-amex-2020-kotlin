package com.sarinawhite.model

import java.math.BigDecimal

class Order(items: List<Item>) {

    private val items: List<Item> = ArrayList(items).filterNotNull()

    fun getTotalCost(): BigDecimal {
        return items.map { item -> item.price }.fold(BigDecimal.ZERO) { totalPrice, itemPrice -> totalPrice.add(itemPrice) }
    }
}