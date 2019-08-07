package com.example.employee.kotlin_shop_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.example.employee.kotlin_shop_test.BaseLibrary.common.AppManager
import com.example.employee.kotlin_shop_test.fragment.CategoryFragment
import com.example.employee.kotlin_shop_test.fragment.HomeFragment
import com.example.employee.kotlin_shop_test.fragment.MeFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    val mHomeFragment by lazy { HomeFragment() }
    val mCategoryFragment by lazy { CategoryFragment() }
    val mcartFragment by lazy { HomeFragment() }
    val mMsgFragment by lazy { HomeFragment() }
    val mMeFragment by lazy { MeFragment() }
    private val mStack = Stack<Fragment>()

    var pressTime: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBottomNavBar.checkCarBadge(20)
        Observable.timer(2, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mBottomNavBar.checkCarBadge(50)
            })

        initView()
        initFragment()
        initBottomNav()
        changeFragment(0)
    }

    private fun initFragment() {
        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.mFl, mHomeFragment)
        manager.add(R.id.mFl, mCategoryFragment)
        manager.add(R.id.mFl, mcartFragment)
        manager.add(R.id.mFl, mMsgFragment)
        manager.add(R.id.mFl, mMeFragment)
        manager.commit()

        mStack.add(mHomeFragment)
        mStack.add(mCategoryFragment)
        mStack.add(mcartFragment)
        mStack.add(mMsgFragment)
        mStack.add(mMeFragment)
    }

    private fun initView() {

    }

    private fun initBottomNav() {
        mBottomNavBar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabReselected(position: Int) {

            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }
        })
    }

    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack) {
            manager.hide(fragment)
        }

        manager.show(mStack[position])
        manager.commit()
    }


    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast("再点一次退出")
            pressTime = time
        } else {
            AppManager.instance.exitApp(this)
        }
    }

    //点击2次退出
}
