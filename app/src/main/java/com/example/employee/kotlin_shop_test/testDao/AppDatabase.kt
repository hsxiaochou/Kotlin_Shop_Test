package com.example.employee.kotlin_shop_test.testDao

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kotlin.base.common.BaseApplication


@Database(entities = [ImageUrl::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun imageUrlDao(): ImageUrlDao

    companion object {
        val instance = Single.sin
    }

    private object Single {

        val sin: AppDatabase = Room.databaseBuilder(
            BaseApplication.instance(),
            AppDatabase::class.java,
            "User.db"
        )
            .allowMainThreadQueries()
            .build()
    }


}