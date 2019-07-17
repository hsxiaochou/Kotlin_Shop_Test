package com.example.employee.kotlin_shop_test.BaseLibrary.presenter.view

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onerror(msg: String)
}