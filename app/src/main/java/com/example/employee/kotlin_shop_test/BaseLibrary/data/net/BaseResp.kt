package com.example.employee.kotlin_shop_test.BaseLibrary.data.net

class BaseResp<out T>(val status: Int, val Message: String, val data: T) {
}