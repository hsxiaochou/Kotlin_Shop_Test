package com.example.employee.kotlin_shop_test.testDao

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ImageUrlConoverters {
    @TypeConverter
    fun stringToObject(value: String): List<MyImageUrl> {
        val listType = object : TypeToken<List<MyImageUrl>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun objectToString(list: List<MyImageUrl>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

}