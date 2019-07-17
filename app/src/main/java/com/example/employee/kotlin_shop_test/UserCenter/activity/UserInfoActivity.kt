package com.example.employee.kotlin_shop_test.UserCenter.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.example.employee.kotlin_shop_test.BaseLibrary.activity.BaseMvpActivity
import com.example.employee.kotlin_shop_test.R
import com.example.employee.kotlin_shop_test.UserCenter.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfoActivity : BaseMvpActivity<LoginPresenter>(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mUserIconIv -> {
                alertShow()
            }
        }
    }

    private fun alertShow() {
        AlertView(
            null ,
            "",
            "取消",
            null,
            arrayOf("拍照", "相册"),
            this,
            AlertView.Style.ActionSheet,
            object : OnItemClickListener {
                override fun onItemClick(o: Any?, position: Int) {
                    when (position) {
                        0 -> {
                        }
                        1 -> {
                        }
                    }
                }
            }).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        initView()
    }

    private fun initView() {
        mUserIconIv.setOnClickListener(this)
    }
}
