package com.example.employee.kotlin_shop_test.UserCenter.presenter

import com.example.employee.kotlin_shop_test.BaseLibrary.presenter.BasePresenter
import com.example.employee.kotlin_shop_test.BaseLibrary.presenter.view.BaseView
import com.example.employee.kotlin_shop_test.BaseLibrary.rx.BaseSubscriber
import com.example.employee.kotlin_shop_test.BaseLibrary.rx.execute
import com.example.employee.kotlin_shop_test.UserCenter.presenter.view.ForgetPwdView
import com.example.employee.kotlin_shop_test.UserCenter.presenter.view.RegisterView
import com.example.employee.kotlin_shop_test.UserCenter.service.UserService
import com.example.employee.kotlin_shop_test.UserCenter.service.impl.UserServiceImpl
import javax.inject.Inject


class ForgetPwdPresenter @Inject constructor() : BasePresenter<ForgetPwdView>() {
    @Inject
    lateinit var userService: UserServiceImpl

    fun forgetPwd(mobile: String, Pwd: String) {
        mView.showLoading()
        userService.forgetPwd(mobile, Pwd)
            .execute(object : BaseSubscriber<String>(mView) {
                override fun onNext(t: String) {
                    mView.onForgetPwdResult("")
                }
            })
    }

}