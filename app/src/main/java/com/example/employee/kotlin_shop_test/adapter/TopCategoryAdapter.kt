package com.example.employee.kotlin_shop_test.adapter

import android.content.Context
import android.graphics.ColorSpace
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employee.kotlin_shop_test.R
import com.example.employee.kotlin_shop_test.domain.Category
import com.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import com.kotlin.base.utils.GlideUtils
import kotlinx.android.synthetic.main.layout_home_discount_item.view.*
import kotlinx.android.synthetic.main.layout_top_category_item.view.*

class TopCategoryAdapter(context: Context) : BaseRecyclerViewAdapter<Category, TopCategoryAdapter.ViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(mContext)
            .inflate(R.layout.layout_top_category_item, parent, false)
        return ViewHolder(view)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val model = dataList[position]
        holder.itemView.mTopCategoryNameTv.text = model.Name
        holder.itemView.mTopCategoryNameTv.isSelected = model.isSelect
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    }
}