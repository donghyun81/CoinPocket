package com.example.coinpocket.data.local

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import javax.inject.Inject

@ProvidedTypeConverter
class ImageVectorTypeConverter @Inject constructor(
 private val moshi:Moshi
) {
    @TypeConverter
    fun fromString(value: String) :ImageVector? {
        val adapter:JsonAdapter<ImageVector> = moshi.adapter(ImageVector::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromImageVetcor(type:ImageVector) : String {
        val adapter:JsonAdapter<ImageVector> = moshi.adapter(ImageVector::class.java)
        return adapter.toJson(type)
    }
}




