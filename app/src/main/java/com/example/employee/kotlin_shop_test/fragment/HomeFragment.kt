package com.example.employee.kotlin_shop_test.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_BANNER_FOUR
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_BANNER_ONE
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_BANNER_THREE
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_BANNER_TWO
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_DISCOUNT_FIVE
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_DISCOUNT_FOUR
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_DISCOUNT_ONE
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_DISCOUNT_THREE
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_DISCOUNT_TWO
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_FLLIPERMSG_ONE
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_FLLIPERMSG_THREE
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_FLLIPERMSG_TWO
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_TOPIC_FIVE
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_TOPIC_FOUR
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_TOPIC_ONE
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_TOPIC_THREE
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.HOME_TOPIC_TWO
import com.example.employee.kotlin_shop_test.BaseLibrary.fragment.BaseFragment
import com.example.employee.kotlin_shop_test.MainActivity
import com.example.employee.kotlin_shop_test.R
import com.example.employee.kotlin_shop_test.adapter.HomeDiscountAdapter
import com.kotlin.base.widgets.BannerImageLoader
import com.kotlin.mall.ui.adapter.TopicAdapter
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.fragment_home.*
import me.crosswall.lib.coverflow.CoverFlow

class HomeFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, null)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        mHomeBanner.setImageLoader(BannerImageLoader())
        mHomeBanner.setImages(listOf(HOME_BANNER_ONE, HOME_BANNER_TWO, HOME_BANNER_THREE, HOME_BANNER_FOUR))
        mHomeBanner.setBannerAnimation(com.youth.banner.Transformer.Accordion)
        mHomeBanner.setIndicatorGravity(BannerConfig.RIGHT)
        mHomeBanner.start()

        //设置flipper
        mNewsFlipperView.setData(listOf(HOME_FLLIPERMSG_ONE, HOME_FLLIPERMSG_TWO, HOME_FLLIPERMSG_THREE))

        initDiscount()
        initTopic()
    }

    private fun initDiscount() {
        val manager = LinearLayoutManager(context)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        mHomeDiscountRv.layoutManager = manager
        val discountAdapter = HomeDiscountAdapter(activity as MainActivity)
        mHomeDiscountRv.adapter = discountAdapter
        discountAdapter.setData(
            mutableListOf(
                HOME_DISCOUNT_ONE, HOME_DISCOUNT_TWO, HOME_DISCOUNT_THREE,
                HOME_DISCOUNT_THREE, HOME_DISCOUNT_FOUR, HOME_DISCOUNT_FIVE
            )
        )

    }

    private fun initTopic() {
        mTopicPager.adapter = TopicAdapter(
            activity as MainActivity, listOf(
                HOME_TOPIC_ONE, HOME_TOPIC_TWO,
                HOME_TOPIC_THREE, HOME_TOPIC_FOUR, HOME_TOPIC_FIVE
            )
        )
        mTopicPager.currentItem = 1
        mTopicPager.offscreenPageLimit = 5
        CoverFlow.Builder().with(mTopicPager).scale(0.3f).pagerMargin(-30.0f).spaceSize(0.0f).build()
    }
}