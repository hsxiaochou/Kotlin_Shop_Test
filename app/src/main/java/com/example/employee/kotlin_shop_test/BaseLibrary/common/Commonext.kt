package com.example.employee.kotlin_shop_test.BaseLibrary.common

import android.graphics.drawable.AnimationDrawable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.employee.kotlin_shop_test.R
import com.kennyc.view.MultiStateView
import com.kotlin.base.utils.GlideUtils
import com.kotlin.base.widgets.DefaultTextWatcher
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_category.view.*
import org.jetbrains.anko.find
import ren.qinc.numberbutton.NumberButton

fun Button.enable(et: EditText, method: () -> Boolean) {
    val btn = this
    et.addTextChangedListener(object : DefaultTextWatcher() {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}

//imageview的拓展
fun ImageView.LoadUrl(url: String) {
    GlideUtils.loadUrlImage(context, url, this)
}

//多状态试图的扩展
fun MultiStateView.startLoading() {
    viewState = MultiStateView.VIEW_STATE_LOADING
    //loading动画
    val loadingView = mMultiStateView.getView(MultiStateView.VIEW_STATE_LOADING)
    val animBackground = loadingView!!.findViewById<View>(R.id.loading_anim_view).background
    (animBackground as AnimationDrawable).start()
}

fun NumberButton.getEditext(): EditText {
    return find(R.id.text_count)

}