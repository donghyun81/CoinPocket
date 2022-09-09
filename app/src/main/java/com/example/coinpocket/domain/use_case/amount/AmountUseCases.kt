package com.example.coinpocket.domain.use_case.amount

data class AmountUseCases (
    val getAmount: GetAmount,
    val addAmount: AddAmount,
    val getDayAccounts: GetDayAccounts,
    val deleteAmount: DeleteAmount,
    val updateAmount: UpdateAmount,
    val getAmounts: GetAmounts,
        )