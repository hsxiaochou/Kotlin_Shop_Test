package com.example.employee.kotlin_shop_test.injection.module

import com.example.employee.kotlin_shop_test.UserCenter.service.UserService
import com.example.employee.kotlin_shop_test.UserCenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

@Module
class UserModule {
    @Provides
    fun ProvidesUserService(service: UserServiceImpl): UserService {
        return service
    }
}