package com.example.employee.kotlin_shop_test.UserCenter.activity


import android.os.Bundle
import com.example.employee.kotlin_shop_test.BaseLibrary.activity.BaseMvpActivity
import com.example.employee.kotlin_shop_test.R
import com.example.employee.kotlin_shop_test.UserCenter.presenter.RegisterPresenter

class RegisterActivity : BaseMvpActivity<RegisterPresenter>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
}
