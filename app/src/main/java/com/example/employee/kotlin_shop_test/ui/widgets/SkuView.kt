package com.example.employee.kotlin_shop_test.ui.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.employee.kotlin_shop_test.R
import com.example.employee.kotlin_shop_test.domain.GoodsSku
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import com.zhy.view.flowlayout.TagFlowLayout
import kotlinx.android.synthetic.main.layout_sku_view.view.*

class SkuView @JvmOverloads constructor(mcontenxt: Context, attrs: AttributeSet? = null, defstyle: Int = 0) :
    FrameLayout(mcontenxt, attrs, defstyle) {

    private lateinit var mGoodsSku: GoodsSku

    init {
        View.inflate(mcontenxt, R.layout.layout_sku_view, this)
    }

    fun setSkuData(goodsSku: GoodsSku) {
        mGoodsSku = goodsSku
        mSkuTitleTv.text = goodsSku.url
        //设置FlowLaout数据
        mSkuContentView.adapter = object : TagAdapter<String>(goodsSku.goods) {
            override fun getView(parent: FlowLayout?, position: Int, t: String?): View {
                val view = LayoutInflater.from(context).inflate(R.layout.layout_sku_item, parent, false) as TextView
                view.text = t
                return view
            }
        }

        mSkuContentView.adapter.setSelectedList(0)
        mSkuContentView.setOnTagClickListener { view, position, parent ->
            true
        }


    }
    //获取选中的sku

    fun getSkuInfo(): String {
        return mSkuTitleTv.text.toString() + " " + mGoodsSku.goods[mSkuContentView.selectedList.first()]

    }

}