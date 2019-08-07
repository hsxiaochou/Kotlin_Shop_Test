package com.example.employee.kotlin_shop_test.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.employee.kotlin_shop_test.BaseLibrary.fragment.BaseFragment
import com.example.employee.kotlin_shop_test.R
import com.example.employee.kotlin_shop_test.UserCenter.activity.LoginActivity
import kotlinx.android.synthetic.main.fragment_me.*
import org.jetbrains.anko.startActivity

class MeFragment : BaseFragment(), View.OnClickListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_me, null)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        mUserNameTv.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mUserNameTv -> {
                activity?.startActivity<LoginActivity>()
            }
        }
    }
}