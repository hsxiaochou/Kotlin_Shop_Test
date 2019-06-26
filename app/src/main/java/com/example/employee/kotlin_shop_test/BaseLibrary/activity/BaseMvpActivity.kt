package com.example.employee.kotlin_shop_test.BaseLibrary.activity

import com.example.employee.kotlin_shop_test.BaseLibrary.presenter.BasePresenter
import com.example.employee.kotlin_shop_test.BaseLibrary.presenter.view.BaseView

open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onerror() {
    }

    lateinit var mPresenter: T

}