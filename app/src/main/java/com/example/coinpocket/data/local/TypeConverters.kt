package com.example.coinpocket.data.local

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.coinpocket.domain.model.IconSample
import com.google.gson.Gson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class IconSampleTypeConverter @Inject constructor(
 private val moshi:Moshi
) {
    @TypeConverter
    fun fromString(value: String) :IconSample? {
        val adapter:JsonAdapter<IconSample> = moshi.adapter(IconSample::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromIconSample(type:IconSample) : String {
        val adapter:JsonAdapter<IconSample> = moshi.adapter(IconSample::class.java)
        return adapter.toJson(type)
    }
}


@ProvidedTypeConverter
class ImageVectorTypeConverter @Inject constructor(
    private val moshi:Moshi
) {
    @TypeConverter
    fun fromString(value: String) :IconSample. {
        val adapter:JsonAdapter<ImageVector> = moshi.adapter(ImageVector::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromIconSample(type:ImageVector) : String {
        val adapter:JsonAdapter<ImageVector> = moshi.adapter(ImageVector::class.java)
        return adapter.toJson(type)
    }
}