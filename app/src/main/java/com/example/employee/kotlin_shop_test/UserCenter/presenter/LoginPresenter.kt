package com.example.employee.kotlin_shop_test.UserCenter.presenter

import com.example.employee.kotlin_shop_test.BaseLibrary.presenter.BasePresenter
import com.example.employee.kotlin_shop_test.BaseLibrary.presenter.view.BaseView
import com.example.employee.kotlin_shop_test.BaseLibrary.rx.BaseSubscriber
import com.example.employee.kotlin_shop_test.BaseLibrary.rx.execute
import com.example.employee.kotlin_shop_test.UserCenter.presenter.view.LoginView
import com.example.employee.kotlin_shop_test.UserCenter.presenter.view.RegisterView
import com.example.employee.kotlin_shop_test.UserCenter.service.UserService
import com.example.employee.kotlin_shop_test.UserCenter.service.impl.UserServiceImpl
import javax.inject.Inject


class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {
    @Inject
    lateinit var userService: UserServiceImpl

    fun Login(mobile: String, Pwd: String) {
        mView.showLoading()
        userService.login(mobile, Pwd)
            .execute(object : BaseSubscriber<Boolean>(mView) {
                override fun onNext(t: Boolean) {
                    mView.onLoginResult(true)
                }
            })
    }

}