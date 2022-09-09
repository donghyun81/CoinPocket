package com.example.coinpocket.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.coinpocket.domain.model.CategoryImage
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class ImageTypeConverter {
    @TypeConverter
    fun fromString(value: String): CategoryImage {
        return Json.decodeFromString(value)
    }
    @TypeConverter
    fun fromImage(type: CategoryImage): String {
       return Json.encodeToString(type)
    }
}







