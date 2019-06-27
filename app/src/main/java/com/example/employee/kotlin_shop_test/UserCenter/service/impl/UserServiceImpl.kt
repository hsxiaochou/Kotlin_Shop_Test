package com.example.employee.kotlin_shop_test.UserCenter.service.impl

import com.example.employee.kotlin_shop_test.BaseLibrary.data.net.BaseResp
import com.example.employee.kotlin_shop_test.BaseLibrary.rx.Baseexcption
import com.example.employee.kotlin_shop_test.UserCenter.data.repository.UserRepository
import com.example.employee.kotlin_shop_test.UserCenter.service.UserService
import rx.Observable
import rx.functions.Func1

class UserServiceImpl : UserService {
    override fun register(mobile: String, verifyCode: String, Pwd: String): Observable<Boolean> {

        val userRepository = UserRepository()
        return userRepository.register(mobile, verifyCode, Pwd)
            .flatMap(object : Func1<BaseResp<String>, Observable<Boolean>> {
                override fun call(t: BaseResp<String>?): Observable<Boolean> {
                    if (t?.status != 0) {
                        return Observable.error(Baseexcption(t!!.status, t!!.Message))
                    }
                    return Observable.just(true)
                }
            })
    }
}