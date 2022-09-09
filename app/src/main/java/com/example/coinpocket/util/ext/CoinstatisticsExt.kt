package com.example.coinpocket.util.ext

import com.example.coinpocket.data.local.AmountEntity

fun List<AmountEntity>.totalYearMonthIncome(yearMonth:String): Long {
    return this
        .filter { it.isDeposit  }
        .filter { it.day.substring(0..6)==yearMonth }
        .sumOf { it.amount.toLong() }
}
fun List<AmountEntity>.totalYearMonthExpense(yearMonth:String): Long {
    return this
        .filter { !it.isDeposit  }
        .filter { it.day.substring(0..6)==yearMonth }
        .sumOf { it.amount.toLong() }
}


fun List<AmountEntity>.categoryTotalIncomeById(id:Long,yearMonth:String): Long {
    return this .filter { it.isDeposit  }
        .filter { it.categoryImage.id==id }
        .filter { it.day.substring(0..6)==yearMonth }
        .sumOf { it.amount.toLong() }
}
fun List<AmountEntity>.categoryTotalExpenseById(id:Long,yearMonth:String): Long {
    return this .filter { !it.isDeposit  }
        .filter { it.categoryImage.id==id }
        .filter { it.day.substring(0..6)==yearMonth }
        .sumOf { it.amount.toLong() }
}

fun Float.format(digits: Int): String {
    return "%.${digits}f".format(this)
}

