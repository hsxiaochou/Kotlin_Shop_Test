package com.example.employee.kotlin_shop_test.testDao

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "Image")
@TypeConverters(ImageUrlConoverters::class)
data class ImageUrl constructor(@PrimaryKey val recordId: Int, val imageUrls: MutableList<MyImageUrl>) {
}

data class MyImageUrl(val imageUrl: String)