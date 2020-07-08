package com.sarinawhite.model

import org.junit.Test
import java.math.BigDecimal
import kotlin.test.assertEquals

class OrderTest {
    @Test
    fun testTotalCost() {
        assertEquals(BigDecimal.ZERO, Order(ArrayList()).getTotalCost())
        assertEquals(Item.APPLE.price, Order(listOf(Item.APPLE)).getTotalCost())
        assertEquals(Item.APPLE.price.add(Item.ORANGE.price), Order(listOf(Item.APPLE, Item.ORANGE)).getTotalCost())
    }
}