package com.example.employee.kotlin_shop_test.UserCenter.presenter

import com.example.employee.kotlin_shop_test.BaseLibrary.presenter.BasePresenter
import com.example.employee.kotlin_shop_test.BaseLibrary.rx.BaseSubscriber
import com.example.employee.kotlin_shop_test.BaseLibrary.rx.execute
import com.example.employee.kotlin_shop_test.UserCenter.presenter.view.RegisterView
import com.example.employee.kotlin_shop_test.UserCenter.service.impl.UserServiceImpl


class RegisterPresenter : BasePresenter<RegisterView>() {
    fun register(mobile: String, verifyCode: String, Pwd: String) {
        val userService = UserServiceImpl()
        userService.register(mobile, verifyCode, Pwd)
            .execute(object : BaseSubscriber<Boolean>() {
                override fun onNext(t: Boolean) {
                    mView.onRegisterResult(true)
                }
            })

    }
}