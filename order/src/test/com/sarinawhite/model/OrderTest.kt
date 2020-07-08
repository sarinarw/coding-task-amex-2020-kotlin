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

    @Test
    fun testTotalCostWithDeals() {
        assertEquals(Item.APPLE.price, Order(List(1) { Item.APPLE }).getTotalCost())
        assertEquals(Item.APPLE.price, Order(List(2) { Item.APPLE }).getTotalCost())
        assertEquals(Item.ORANGE.price.times(BigDecimal(2)), Order(List(3) { Item.ORANGE }).getTotalCost())
        assertEquals(Item.ORANGE.price.times(BigDecimal(3)), Order(List(4) { Item.ORANGE }).getTotalCost())
        assertEquals(Item.ORANGE.price.times(BigDecimal(4)), Order(List(5) { Item.ORANGE }).getTotalCost())
        assertEquals(Item.ORANGE.price.times(BigDecimal(4)), Order(List(6) { Item.ORANGE }).getTotalCost())
        assertEquals(Item.ORANGE.price.times(BigDecimal(2)).add(Item.APPLE.price), Order(listOf(List(3) { Item.ORANGE }, List(2) { Item.APPLE }).flatten()).getTotalCost())
    }
}