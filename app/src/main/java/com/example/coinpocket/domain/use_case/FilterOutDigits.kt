package com.example.coinpocket.domain.use_case

import dagger.Binds

class FilterOutDigits {
    operator fun invoke(text: String): String {
        return text.filter { it.isDigit() }
    }
}