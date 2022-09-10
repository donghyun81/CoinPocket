package com.example.coinpocket.util.ext

import com.example.coinpocket.data.local.AmountEntity
import java.text.DecimalFormat
import java.text.NumberFormat

fun List<AmountEntity>.totalDayIncome(day:String): String {
    return this.filter { it.day==day }
        .filter { it.isDeposit }
        .sumOf { it.amount } .justMoney()
}

fun List<AmountEntity>.totalDayExpense(day:String): String {
    return this.filter { it.day==day }
        .filter { !it.isDeposit }
        .sumOf { it.amount } .justMoney()
}



fun Int.justMoney(): String {
    if(this<=0) {
        return ""
    }else{
        val formatter = DecimalFormat("#,###") as NumberFormat
        return formatter.format(this)
    }
}

