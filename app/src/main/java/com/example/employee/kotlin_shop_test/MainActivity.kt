package com.example.employee.kotlin_shop_test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.employee.kotlin_shop_test.BaseLibrary.common.AppManager
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    var pressTime: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast("再点一次退出")
            pressTime = time
        } else {
            AppManager.instance.exitApp(this)
        }
    }

    //点击2次退出
}
