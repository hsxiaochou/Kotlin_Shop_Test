package com.example.employee.kotlin_shop_test.UserCenter.presenter.view

import com.example.employee.kotlin_shop_test.BaseLibrary.presenter.view.BaseView

interface LoginView : BaseView {

    fun onLoginResult(result: Boolean)

}