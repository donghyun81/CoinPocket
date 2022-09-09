package com.example.coinpocket.domain.model

import androidx.annotation.DrawableRes
import com.example.coinpocket.R
import com.example.coinpocket.ui.theme.getExpenseColor
import com.example.coinpocket.ui.theme.getIncomeColor
import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@Serializable
data class CategoryImage(
    val id:Long,
    @DrawableRes val imageUrl:Int,
    val color:Long
)

val incomeCategoryImages = listOf(
    CategoryImage(
        id=0L,
        imageUrl = R.drawable.img,
        color = getIncomeColor()[0]
    ),
    CategoryImage(
        id=1L,
        imageUrl = R.drawable.img,
        color = getIncomeColor()[1]
    ),
    CategoryImage(
        id=2L,
        imageUrl = R.drawable.img,
        color = getIncomeColor()[2]
    ),
    CategoryImage(
        id=3L,
        imageUrl = R.drawable.img,
        color = getIncomeColor()[3]
    )

)

val expenseCategoryImages = listOf(
    CategoryImage(
        id=0L,
        imageUrl = R.drawable.img,
        color = getExpenseColor()[0]
    ),
    CategoryImage(
        id=1L,
        imageUrl = R.drawable.img,
        color = getExpenseColor()[1]
    ),
    CategoryImage(
        id=2L,
        imageUrl = R.drawable.img,
        color = getExpenseColor()[2]
    ),
    CategoryImage(
        id=3L,
        imageUrl = R.drawable.img,
        color = getExpenseColor()[3]
    ),
    CategoryImage(
        id=4L,
        imageUrl = R.drawable.img,
        color = getExpenseColor()[4]
    ),
    CategoryImage(
        id=5L,
        imageUrl = R.drawable.img,
        color = getExpenseColor()[5]
    )
)

