package com.example.employee.kotlin_shop_test.UserCenter.service

import rx.Observable

interface UserService {
    fun register(mobile: String, verifyCode: String, Pwd: String): Observable<Boolean>
    fun login(mobile: String, Pwd: String): Observable<Boolean>

    fun forgetPwd(mobile: String, Pwd: String): Observable<String>

}