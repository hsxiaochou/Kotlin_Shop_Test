package com.example.employee.kotlin_shop_test.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.employee.kotlin_shop_test.BaseLibrary.activity.BaseActivity
import com.example.employee.kotlin_shop_test.BaseLibrary.common.startLoading
import com.example.employee.kotlin_shop_test.R
import kotlinx.android.synthetic.main.activity_goods.*

class GoodsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods)
        initView()
    }

    private fun initView() {
        mMultiStateView.startLoading()
    }
}
