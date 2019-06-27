package com.example.employee.kotlin_shop_test.UserCenter.activity


import android.os.Bundle
import com.example.employee.kotlin_shop_test.BaseLibrary.activity.BaseMvpActivity
import com.example.employee.kotlin_shop_test.R
import com.example.employee.kotlin_shop_test.UserCenter.presenter.RegisterPresenter
import com.example.employee.kotlin_shop_test.UserCenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {
    override fun onRegisterResult(result: Boolean) {
        toast("注册成功")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mPresenter = RegisterPresenter()
        mPresenter.mView = this
        mRegisterBtn.setOnClickListener {
            mPresenter.register("11111", "2222", "");
        }
    }
}
