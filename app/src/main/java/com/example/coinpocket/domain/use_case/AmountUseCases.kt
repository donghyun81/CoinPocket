package com.example.coinpocket.domain.use_case

data class AmountUseCases (
    val getCoin: GetAmount,
    val addAmount: AddAmount,
    val getDayAccounts: GetDayAccounts,
    val deleteAmount: DeleteAmount,
    val updateAmount: UpdateAmount
        )