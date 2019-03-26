package com.example.tim.foodapp.data.local

import android.arch.persistence.room.TypeConverter
import com.example.tim.foodapp.data.models.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*
import java.util.Collections.emptyList


class Converters {

    companion object {

        var gson = Gson()

        @TypeConverter
        @JvmStatic
        fun stringToSomeObjectList(data: String?): List<Product> {
            if (data == null) {
                return Collections.emptyList()
            }
            val listType = object : TypeToken<List<Product>>() {
            }.type
            return gson.fromJson(data, listType)
        }

        @TypeConverter
        @JvmStatic
        fun someObjectListToString(products: List<Product>): String {
            return gson.toJson(products)
        }
    }
}