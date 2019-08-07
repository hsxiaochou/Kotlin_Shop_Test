package com.example.employee.kotlin_shop_test.BaseLibrary.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.employee.kotlin_shop_test.BaseLibrary.common.AppManager
import com.example.employee.kotlin_shop_test.R
import org.jetbrains.anko.find

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        AppManager.instance.addActivity(this)
    }


    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActiviy(this)
    }

    val contenView: View
        get() {
            val content = find<FrameLayout>(android.R.id.content)
            return content.getChildAt(0)
        }
}