package com.example.employee.kotlin_shop_test.ui.widgets

import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.RelativeLayout
import com.example.employee.kotlin_shop_test.BaseLibrary.common.LoadUrl
import com.example.employee.kotlin_shop_test.BaseLibrary.common.getEditext
import com.example.employee.kotlin_shop_test.R
import com.example.employee.kotlin_shop_test.domain.GoodsSku
import com.kotlin.base.widgets.DefaultTextWatcher
import kotlinx.android.synthetic.main.layout_sku_pop.view.*

class GoodsSkuPopView(context: Context) : PopupWindow(context), View.OnClickListener {


    private val mContext: Context
    private val rootView: View
    private val mSkuViewlist = arrayListOf<SkuView>()

    init {
        mContext = context
        val infalter = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        rootView = infalter.inflate(R.layout.layout_sku_pop, null)
        initView()

        this.contentView = rootView//设置popuwindow的view
        this.width = ViewGroup.LayoutParams.MATCH_PARENT
        this.height = ViewGroup.LayoutParams.WRAP_CONTENT

        this.isFocusable = true
        this.animationStyle = R.style.AnimBottom
        this.background.alpha = 150

        rootView.setOnTouchListener { v, event ->

            //得到popuwindow的上面的高，点击大于高。就取消弹窗
            val height = rootView.findViewById<RelativeLayout>(R.id.mPopView).top
            val y = event.y.toInt()

            if (event.action == MotionEvent.ACTION_UP) {
                if (y < height) {
                    dismiss()
                }
            }



            true
        }
    }

    private fun initView() {
        rootView.mCloseIv.setOnClickListener(this)
        rootView.mAddCartBtn.setOnClickListener(this)
        rootView.mSkuCountBtn.setCurrentNumber(1)
        rootView.mSkuCountBtn.getEditext().addTextChangedListener(object : DefaultTextWatcher() {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }

    fun getSelectCount() = rootView.mSkuCountBtn.number
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mCloseIv -> dismiss()
            R.id.mAddCartBtn -> dismiss()
        }
    }

    //设置图标
    fun setGsoosIcon(text: String) {
        rootView.mGoodsIconIv.LoadUrl(text)
    }

    //设置商品价格
    fun setGoodsPrice(text: String) {
        rootView.mGoodsPriceTv.text = text
    }

    fun setSkuData(list: List<GoodsSku>) {
        for (goodSku in list) {
            val skuView = SkuView(mContext)
            skuView.setSkuData(goodSku)


            mSkuViewlist.add(skuView)
            rootView.mSkuView.addView(skuView)

        }

    }

    fun getSelectSku(): String {
        var skuInfo = ""

        for (sku in mSkuViewlist) {
            skuInfo += sku.getSkuInfo().split(",")
        }

        return skuInfo.take(skuInfo.length - 1)
    }

}