package com.sarinawhite.model

import java.math.BigDecimal

enum class Item(val price: BigDecimal, val deal: Deal, val stock: Int) {
    APPLE(BigDecimal.valueOf(0.60), Deal.BOGO, 5),
    ORANGE(BigDecimal.valueOf(0.25), Deal.THREE_FOR_TWO, 5);
}