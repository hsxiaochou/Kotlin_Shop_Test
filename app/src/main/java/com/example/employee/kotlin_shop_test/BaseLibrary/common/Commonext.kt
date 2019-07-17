package com.example.employee.kotlin_shop_test.BaseLibrary.common

import android.widget.Button
import android.widget.EditText
import com.kotlin.base.widgets.DefaultTextWatcher

fun Button.enable(et: EditText, method: () -> Boolean) {
    val btn = this
    et.addTextChangedListener(object : DefaultTextWatcher() {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}