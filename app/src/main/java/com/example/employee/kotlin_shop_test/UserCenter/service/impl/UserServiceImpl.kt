package com.example.employee.kotlin_shop_test.UserCenter.service.impl

import com.example.employee.kotlin_shop_test.BaseLibrary.data.net.BaseResp
import com.example.employee.kotlin_shop_test.BaseLibrary.rx.Baseexcption
import com.example.employee.kotlin_shop_test.UserCenter.data.repository.UserRepository
import com.example.employee.kotlin_shop_test.UserCenter.service.UserService
import rx.Observable
import rx.functions.Func1
import javax.inject.Inject

class UserServiceImpl @Inject constructor() : UserService {
    @Inject
    lateinit var userRepository: UserRepository

    override fun register(mobile: String, verifyCode: String, Pwd: String): Observable<Boolean> {
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

    override fun login(mobile: String, Pwd: String): Observable<Boolean> {
        return userRepository.Login(mobile, Pwd)
            .flatMap(object : Func1<BaseResp<String>, Observable<Boolean>> {
                override fun call(t: BaseResp<String>?): Observable<Boolean> {
                    if (t?.status != 0) {
                        return Observable.error(Baseexcption(t!!.status, t!!.Message))
                    }
                    return Observable.just(true)
                }
            })
    }

    override fun forgetPwd(mobile: String, Pwd: String): Observable<String> {
        return userRepository.forgetPwd(mobile, Pwd)
            .flatMap(object : Func1<BaseResp<String>, Observable<String>> {
                override fun call(t: BaseResp<String>?): Observable<String> {
                    if (t?.status != 0) {
                        return Observable.error(Baseexcption(t!!.status, t!!.Message))
                    }
                    return Observable.just("")
                }
            })
    }


}