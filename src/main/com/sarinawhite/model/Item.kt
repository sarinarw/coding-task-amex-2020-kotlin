package com.sarinawhite.model

import java.math.BigDecimal

enum class Item(val price: BigDecimal, val deal: Deal) {
    APPLE(BigDecimal.valueOf(0.60), Deal.BOGO),
    ORANGE(BigDecimal.valueOf(0.25), Deal.THREE_FOR_TWO);
}