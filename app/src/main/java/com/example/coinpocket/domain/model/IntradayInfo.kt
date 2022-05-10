package com.example.coinpocket.domain.model

import java.time.LocalDateTime

data class IntradayInfo(
    val date:LocalDateTime,
    val close:Double

)
