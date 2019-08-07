package com.example.employee.kotlin_shop_test.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.IntegerRes
import com.example.employee.kotlin_shop_test.BaseLibrary.activity.BaseActivity
import com.example.employee.kotlin_shop_test.R
import com.example.employee.kotlin_shop_test.testDao.*
import com.kotlin.base.common.BaseApplication
import kotlinx.android.synthetic.main.activity_goods__test.*

private val bookList: MutableList<MyImageUrl> = arrayListOf()

class Goods_TestActivity : BaseActivity(), View.OnClickListener {
    var imageDao: ImageUrlDao? = null
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mSave -> {
                val imageUrl = imageDao?.getImageUrl(mTestid.text.toString().toInt())
                if (imageUrl!=null){
                    imageUrl?.imageUrls?.add(MyImageUrl(mTestEt.text.toString()))
                    imageDao?.insertImage(ImageUrl(mTestid.text.toString().toInt(), imageUrl?.imageUrls!!))
                }else{
                    imageDao?.insertImage(ImageUrl(mTestid.text.toString().toInt(), mutableListOf(MyImageUrl(mTestEt.text.toString()))))
                }

            }
            R.id.mQuery -> {
                Log.e("TAG", imageDao?.getImageUrl(mTestid.text.toString().toInt()).toString())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods__test)
        mSave.setOnClickListener(this)
        mQuery.setOnClickListener(this)
        imageDao = AppDatabase.instance.imageUrlDao()
    }
}
