package com.sarinawhite.helper

import com.sarinawhite.model.Item

/*
 Takes a string and attempts to parse it into an Item.
 This allows for controlled error handling, and being able to map the string to the error.
 */
class StringToItem(str: String) {
    val itemString: String = str.trim()
    private val itemResult: Result<Item> =
            try {
                Result.success(Item.valueOf(itemString.toUpperCase()))
            } catch(e: Throwable) {
                Result.failure(e)
            }

    fun isSuccess(): Boolean {
        return itemResult.isSuccess
    }

    fun getItem(): Item {
        return itemResult.getOrThrow()
    }
}