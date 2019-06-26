package com.example.employee.kotlin_shop_test.BaseLibrary

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

class AppManager private constructor() {

    private val activiyStack: Stack<Activity> = Stack()

    companion object {
        val instance: AppManager by lazy { AppManager() }
    }
    //入栈
    fun addActivity(activity: Activity) {
        activiyStack.add(activity)
    }

    //出栈
    fun finishActiviy(activity: Activity) {
        activity.finish()
        activiyStack.remove(activity)
    }

    //当前栈顶
    fun currentActivity(): Activity {
        return activiyStack.lastElement()
    }

    //消除栈所有元素
    fun finishAllActiviy() {
        for (activiy in activiyStack) {
            activiy.finish()
        }
        activiyStack.clear()
    }

    //退出对象
    fun exitApp(context: Context) {
        finishAllActiviy()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }

}