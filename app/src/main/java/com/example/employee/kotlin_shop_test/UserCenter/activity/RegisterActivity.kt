package com.example.employee.kotlin_shop_test.UserCenter.activity


import android.os.Bundle
import android.widget.Toast
import com.example.employee.kotlin_shop_test.BaseLibrary.activity.BaseMvpActivity
import com.example.employee.kotlin_shop_test.BaseLibrary.common.enable
import com.example.employee.kotlin_shop_test.R
import com.example.employee.kotlin_shop_test.UserCenter.presenter.RegisterPresenter
import com.example.employee.kotlin_shop_test.UserCenter.presenter.view.RegisterView
import com.example.employee.kotlin_shop_test.injection.component.DaggerUserComponent
import com.example.employee.kotlin_shop_test.injection.module.UserModule
import com.kotlin.base.utils.NetWorkUtils
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    override fun onRegisterResult(result: Boolean) {
        toast("注册成功")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initInjection()

        mRegisterBtn.enable(mMobileEt, { isButtonEnnable() })
        mRegisterBtn.enable(mVerifyCodeEt, { isButtonEnnable() })
        mRegisterBtn.enable(mPwdEt, { isButtonEnnable() })
        mRegisterBtn.enable(mPwdConfirmEt, { isButtonEnnable() })

        mRegisterBtn.setOnClickListener {
            if (!NetWorkUtils.isNetWorkAvailable(this)) {
                toast("网络不可用")
                return@setOnClickListener
            }
            mPresenter.register("11111", "2222", "");
        }
    }

    private fun initInjection() {
        DaggerUserComponent.builder().userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }


    private fun isButtonEnnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }
}
