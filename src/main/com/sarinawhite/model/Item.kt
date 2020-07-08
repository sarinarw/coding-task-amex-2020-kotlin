package com.sarinawhite.model

import java.math.BigDecimal

enum class Item(val price: BigDecimal) {
    APPLE(BigDecimal.valueOf(0.60)),
    ORANGE(BigDecimal.valueOf(0.25));
}