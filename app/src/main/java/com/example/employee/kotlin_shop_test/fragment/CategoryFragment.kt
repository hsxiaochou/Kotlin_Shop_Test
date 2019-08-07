package com.example.employee.kotlin_shop_test.fragment

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.topListData
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.SencondListData1
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.SencondListData2
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.SencondListData3
import com.example.employee.kotlin_shop_test.BaseLibrary.common.startLoading
import com.example.employee.kotlin_shop_test.BaseLibrary.fragment.BaseFragment
import com.example.employee.kotlin_shop_test.MainActivity
import com.example.employee.kotlin_shop_test.R
import com.example.employee.kotlin_shop_test.adapter.SecondCategoryAdapter
import com.example.employee.kotlin_shop_test.adapter.TopCategoryAdapter
import com.example.employee.kotlin_shop_test.domain.Category
import com.example.employee.kotlin_shop_test.ui.activity.GoodsActivity
import com.kennyc.view.MultiStateView
import com.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_category.*
import org.jetbrains.anko.startActivity

class CategoryFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val RootView = inflater.inflate(R.layout.fragment_category, null)
        return RootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        mTopCategoryRv.layoutManager = LinearLayoutManager(context)
        val toAdapter = TopCategoryAdapter(context!!)
        topListData[0].isSelect = true
        toAdapter.setData(topListData)
        mTopCategoryRv.adapter = toAdapter

        mSecondCategoryRv.layoutManager = GridLayoutManager(context, 3)
        val secondAdapter = SecondCategoryAdapter(context!!)
        secondAdapter.setData(SencondListData1)
        mSecondCategoryRv.adapter = secondAdapter
        //多状态试图
//        mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT

        mMultiStateView.startLoading()
        toAdapter.setOnItemClickListener(object : BaseRecyclerViewAdapter.OnItemClickListener<Category> {
            override fun onItemClick(item: Category, position: Int) {
                for (catefory in toAdapter.dataList) {
                    catefory.isSelect = item.id == catefory.id
                }
                when (item.id) {
                    "1" -> {
                        secondAdapter.setData(SencondListData1)
                    }
                    "2" -> {
                        secondAdapter.setData(SencondListData2)
                    }
                    else -> {
                        secondAdapter.setData(SencondListData3)
                    }
                }
                if (secondAdapter.dataList.size > 0) {
                    mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT
                } else {
                    mMultiStateView.viewState = MultiStateView.VIEW_STATE_EMPTY
                }
                toAdapter.notifyDataSetChanged()
            }
        })

        secondAdapter.setOnItemClickListener(object : BaseRecyclerViewAdapter.OnItemClickListener<Category> {
            override fun onItemClick(item: Category, position: Int) {
                (activity as MainActivity).startActivity<GoodsActivity>()
            }
        })

    }
}