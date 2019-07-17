package com.example.employee.kotlin_shop_test.BaseLibrary.widgets

import android.content.Context
import android.util.AttributeSet
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.ShapeBadgeItem
import com.ashokvarma.bottomnavigation.TextBadgeItem
import com.example.employee.kotlin_shop_test.R

class BottomNavBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationBar(context, attrs, defStyleAttr) {


    private val mCarBadge: TextBadgeItem
    private val mMsgBadge: ShapeBadgeItem

    init {

        mCarBadge = TextBadgeItem()
        mMsgBadge = ShapeBadgeItem()
        //首页
        val homeItem = BottomNavigationItem(R.drawable.btn_nav_home_press, resources.getString(R.string.nav_bar_home))
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)
            .setInactiveIconResource(R.drawable.btn_nav_home_normal)

        homeItem.setBadgeItem(mCarBadge)
        mCarBadge.setText("10")

        //分类
        val categoryItem =
            BottomNavigationItem(R.drawable.btn_nav_cart_press, resources.getString(R.string.nav_bar_category))
                .setActiveColorResource(R.color.common_blue)
                .setInActiveColorResource(R.color.text_normal)
                .setInactiveIconResource(R.drawable.btn_nav_cart_normal)
        //消息
        val msgItem = BottomNavigationItem(R.drawable.btn_nav_msg_press, resources.getString(R.string.nav_bar_msg))
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)
            .setInactiveIconResource(R.drawable.btn_nav_msg_normal)

        msgItem.setBadgeItem(mMsgBadge)
        //首页
        val UserItem = BottomNavigationItem(R.drawable.btn_nav_user_press, resources.getString(R.string.nav_bar_user))
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)
            .setInactiveIconResource(R.drawable.btn_nav_user_normal)

        setMode(BottomNavigationBar.MODE_FIXED)
        setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        setBarBackgroundColor(R.color.common_white)

        addItem(homeItem)
            .addItem(categoryItem)
            .addItem(msgItem)
            .addItem(UserItem)
            .setFirstSelectedPosition(0)
            .initialise()

    }

    fun checkCarBadge(cunt: Int) {
        if (cunt == 0) {
            mCarBadge.hide()
        } else {
            mCarBadge.show()
            mCarBadge.setText("$cunt")
        }
    }

    fun checkShopBadge(cunt: Int) {
        if (cunt == 0) {
            mMsgBadge.hide()
        } else {
            mMsgBadge.show()
        }
    }
}