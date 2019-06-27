package com.example.employee.kotlin_shop_test.UserCenter.data.api

import com.example.employee.kotlin_shop_test.BaseLibrary.data.net.BaseResp
import com.example.employee.kotlin_shop_test.UserCenter.data.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable


interface UserApi {
    @POST("/userCenter/register")
    fun register(@Body body: RegisterReq): Observable<BaseResp<String>>
}