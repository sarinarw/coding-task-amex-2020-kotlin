package com.sarinawhite.helper

import com.sarinawhite.model.Item
import kotlin.test.assertEquals
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringToItemTest {
    @Test
    fun testValidString() {
        val apple = StringToItem("APPLE")
        assertTrue(apple.isSuccess())
        assertEquals(Item.APPLE, apple.getItem())
        val orange = StringToItem("     orAngE    ")
        assertTrue(orange.isSuccess())
        assertEquals(Item.ORANGE, orange.getItem())
    }

    @Test
    fun testInvalidString() {
        assertFalse(StringToItem("ap ple").isSuccess())
        assertFalse(StringToItem("potato").isSuccess())
        assertFalse(StringToItem("").isSuccess())
    }
}