package com.example.employee.kotlin_shop_test.UserCenter.presenter

import com.example.employee.kotlin_shop_test.BaseLibrary.presenter.BasePresenter
import com.example.employee.kotlin_shop_test.BaseLibrary.presenter.view.BaseView
import com.example.employee.kotlin_shop_test.BaseLibrary.rx.BaseSubscriber
import com.example.employee.kotlin_shop_test.BaseLibrary.rx.execute
import com.example.employee.kotlin_shop_test.UserCenter.presenter.view.RegisterView
import com.example.employee.kotlin_shop_test.UserCenter.service.UserService
import com.example.employee.kotlin_shop_test.UserCenter.service.impl.UserServiceImpl
import javax.inject.Inject


class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {
    @Inject
    lateinit var userService: UserServiceImpl
    fun register(mobile: String, verifyCode: String, Pwd: String) {
        mView.showLoading()
        userService.register(mobile, verifyCode, Pwd)
            .execute(object : BaseSubscriber<Boolean>(mView) {
                override fun onNext(t: Boolean) {
                    mView.onRegisterResult(true)
                }
            })
    }

}