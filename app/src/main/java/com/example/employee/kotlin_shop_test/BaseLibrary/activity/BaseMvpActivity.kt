package com.example.employee.kotlin_shop_test.BaseLibrary.activity

import android.os.Bundle
import android.os.PersistableBundle
import com.example.employee.kotlin_shop_test.BaseLibrary.presenter.BasePresenter
import com.example.employee.kotlin_shop_test.BaseLibrary.presenter.view.BaseView
import com.example.employee.kotlin_shop_test.BaseLibrary.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    private final lateinit var mDialog: ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        mDialog = ProgressLoading.create(this)

    }

    override fun showLoading() {
        mDialog.showLoading()
    }

    override fun hideLoading() {
        mDialog.hideLoading()
    }

    override fun onerror(msg: String) {
        toast(msg)
    }

    @Inject
    lateinit var mPresenter: T

}