package com.example.employee.kotlin_shop_test.ui.widgets

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.widget.ImageView
import com.example.employee.kotlin_shop_test.R

class ProgressLoading private constructor(context: Context, them: Int) : Dialog(context, them) {
    companion object {

        lateinit var mDialog: ProgressLoading
        var animDrawable: AnimationDrawable? = null
        fun create(context: Context): ProgressLoading {
            mDialog = ProgressLoading(context, R.style.LightProgressDialog)
            mDialog.setContentView(R.layout.progress_dialog)
            mDialog.setCancelable(true)
            mDialog.setCanceledOnTouchOutside(false)
            mDialog.window.attributes.gravity = Gravity.CENTER

            val lp = mDialog.window.attributes
            lp.dimAmount = 0.2f

            mDialog.window.attributes = lp
            val loadingView = mDialog.findViewById<ImageView>(R.id.iv_loading)
            animDrawable = loadingView.background as AnimationDrawable


            return mDialog
        }
    }

    fun showLoading() {
        super.show()
        animDrawable?.start()
    }

    fun hideLoading() {
        super.hide()
        animDrawable?.stop()
    }
}