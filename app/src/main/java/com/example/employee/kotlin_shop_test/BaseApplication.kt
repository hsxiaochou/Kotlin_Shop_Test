package com.kotlin.base.common

import android.app.Application
import android.content.Context
import com.example.employee.kotlin_shop_test.testDao.AppDatabase
import androidx.room.Room
import kotlin.properties.Delegates


/*
    Application 基类
 */
open class BaseApplication : Application() {

    lateinit var mAppDatabase: AppDatabase
    override fun onCreate() {
        super.onCreate()
        instance = this
        mAppDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "imageurl.db")
            .allowMainThreadQueries()
            .build()
    }
    /*
        全局伴生对象
     */
    companion object {
        var instance: BaseApplication by Delegates.notNull()
        fun instance() = instance
    }
}
