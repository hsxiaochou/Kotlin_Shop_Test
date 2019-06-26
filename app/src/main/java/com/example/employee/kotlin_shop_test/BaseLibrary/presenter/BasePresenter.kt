package com.example.employee.kotlin_shop_test.BaseLibrary.presenter

import com.example.employee.kotlin_shop_test.BaseLibrary.presenter.view.BaseView

open class BasePresenter<T : BaseView> {
    lateinit var mView: T
}