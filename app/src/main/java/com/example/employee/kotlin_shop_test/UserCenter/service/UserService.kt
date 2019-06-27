package com.example.employee.kotlin_shop_test.UserCenter.service

import rx.Observable

interface UserService {
    fun register(mobile: String, verifyCode: String, Pwd: String): Observable<Boolean>
}