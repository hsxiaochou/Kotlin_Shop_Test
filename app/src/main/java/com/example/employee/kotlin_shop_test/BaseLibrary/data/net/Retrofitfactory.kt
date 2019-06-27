package com.example.employee.kotlin_shop_test.BaseLibrary.data.net

import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Retrofitfactory private constructor() {

    companion object {
        val instance: Retrofitfactory by lazy { Retrofitfactory() }
    }

    private val retrofit: Retrofit
    private val intereceptor: Interceptor

    init {

        intereceptor = Interceptor { chain ->
            val request =
                chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("charset", "utf-8")
                    .build()
            chain.proceed(request)
        }
        retrofit = Retrofit.Builder()
            .baseUrl(Constant.SERVER_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(initClient())
            .build()

    }

    private fun initClient(): OkHttpClient? {

        return OkHttpClient.Builder()
            .addInterceptor(initLogInterceptor())
            .addInterceptor(intereceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()

    }

    private fun initLogInterceptor(): Interceptor? {

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }


    fun <T> Create(service: Class<T>): T {
        return retrofit.create(service)
    }
}