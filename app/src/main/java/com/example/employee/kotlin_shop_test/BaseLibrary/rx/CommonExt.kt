package com.example.employee.kotlin_shop_test.BaseLibrary.rx

import rx.Observable
import rx.Scheduler
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>) {
    this.observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(subscriber)
}