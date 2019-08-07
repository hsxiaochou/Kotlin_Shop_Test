package com.example.employee.kotlin_shop_test.UserCenter.activity

import android.os.Bundle
import android.view.View
import com.example.employee.kotlin_shop_test.BaseLibrary.activity.BaseMvpActivity
import com.example.employee.kotlin_shop_test.BaseLibrary.common.enable
import com.example.employee.kotlin_shop_test.R
import com.example.employee.kotlin_shop_test.UserCenter.presenter.LoginPresenter
import com.example.employee.kotlin_shop_test.UserCenter.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.mMobileEt
import kotlinx.android.synthetic.main.activity_register.mPwdEt
import org.jetbrains.anko.clearTop
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.startActivity

class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {

    lateinit var LoginPresenterImp: LoginPresenter

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mLoginBtn -> {
//                LoginPresenterImp.Login(mMobileEt.text.toString(), mPwdEt.text.toString())
                startActivity(intentFor<UserInfoActivity>().singleTop().clearTop())
            }
            R.id.mForgetPwdTv -> {
                startActivity<ForgetPwdActivity>("mobile" to mMobileEt.text.toString())
            }

        }
    }

    override fun onLoginResult(result: Boolean) {
        //注册返回的结果
        startActivity(intentFor<LoginActivity>().singleTop().clearTop())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
        LoginPresenterImp = LoginPresenter()
    }

    private fun initView() {
        mLoginBtn.enable(mMobileEt, { isButtonEnnable() })
        mLoginBtn.enable(mPwdEt, { isButtonEnnable() })
        mLoginBtn.setOnClickListener(this)
        mForgetPwdTv.setOnClickListener(this)
    }

    private fun isButtonEnnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }
}
