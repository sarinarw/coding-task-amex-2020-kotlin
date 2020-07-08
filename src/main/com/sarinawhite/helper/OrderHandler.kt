package com.sarinawhite.helper

import com.sarinawhite.model.Item

class OrderHandler {
    companion object {
        // returns pair of <valid items, invalid strings found in order>
        fun handleOrder(order: String): Pair<List<Item>, List<String>> {
            val stringToItems = order.split(',').map {
                itemString ->
                StringToItem(itemString)
            }

            val validItems = stringToItems
                    .filter { strToItem -> strToItem.isSuccess() }
                    .map { strToItem -> strToItem.getItem() }
            val invalidItemStrings = stringToItems
                    .filter { strToItem -> !strToItem.isSuccess() }
                    .map { strToItem -> strToItem.itemString }

            return Pair(validItems, invalidItemStrings)
        }
    }
}