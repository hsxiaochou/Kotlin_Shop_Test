package com.example.employee.kotlin_shop_test.injection.component

import com.example.employee.kotlin_shop_test.UserCenter.activity.RegisterActivity
import com.example.employee.kotlin_shop_test.injection.module.UserModule
import dagger.Component

@Component(modules = arrayOf(UserModule::class))

interface UserComponent {
    fun inject(activity: RegisterActivity)
}