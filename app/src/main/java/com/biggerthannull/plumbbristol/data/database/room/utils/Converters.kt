package com.biggerthannull.plumbbristol.data.database.room.utils

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun fromList(value : List<String>) =  Gson().toJson(value)

    @TypeConverter
    fun toList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}