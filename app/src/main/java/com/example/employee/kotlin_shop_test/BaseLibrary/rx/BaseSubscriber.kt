package com.example.employee.kotlin_shop_test.BaseLibrary.rx

import com.example.employee.kotlin_shop_test.BaseLibrary.presenter.view.BaseView
import rx.Subscriber

open class BaseSubscriber<T>(val baseView: BaseView) : Subscriber<T>() {
    override fun onNext(t: T) {
    }


    override fun onCompleted() {
        baseView.hideLoading()
    }

    override fun onError(e: Throwable?) {
        baseView.hideLoading()
    }

}