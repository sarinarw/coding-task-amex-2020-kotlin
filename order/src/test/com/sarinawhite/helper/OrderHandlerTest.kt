package com.sarinawhite.helper

import com.sarinawhite.model.Item
import kotlin.test.Test
import kotlin.test.assertEquals

class OrderHandlerTest {
    @Test
    fun testHandleOrderValidString() {
        val orderResult = OrderHandler.handleOrder("  apple    ,    Orange  ")
        assertEquals(listOf(Item.APPLE, Item.ORANGE), orderResult.first)
        assertEquals(0, orderResult.second.size)
    }

    @Test
    fun testHandleOrderInvalidString() {
        val orderResult = OrderHandler.handleOrder("  apple    ,  cantelope,  Orange  ")
        assertEquals(listOf(Item.APPLE, Item.ORANGE), orderResult.first)
        assertEquals(1, orderResult.second.size)
        assertEquals("cantelope", orderResult.second[0])
    }

}