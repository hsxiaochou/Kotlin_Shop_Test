package com.example.employee.kotlin_shop_test.UserCenter.data.repository

import com.example.employee.kotlin_shop_test.BaseLibrary.data.net.BaseResp
import com.example.employee.kotlin_shop_test.BaseLibrary.data.net.Retrofitfactory
import com.example.employee.kotlin_shop_test.UserCenter.data.api.UserApi
import com.example.employee.kotlin_shop_test.UserCenter.data.protocol.RegisterReq
import retrofit2.http.Body
import rx.Observable

class UserRepository {
    fun register(mobile: String, verifyCode: String, pwd: String): Observable<BaseResp<String>> {
        return Retrofitfactory.instance.Create(UserApi::class.java).register(RegisterReq(mobile, verifyCode, pwd))
    }
}