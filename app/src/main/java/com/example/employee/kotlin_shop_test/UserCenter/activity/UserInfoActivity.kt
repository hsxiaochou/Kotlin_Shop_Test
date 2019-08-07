package com.example.employee.kotlin_shop_test.UserCenter.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.core.app.ActivityCompat
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.example.employee.kotlin_shop_test.BaseLibrary.activity.BaseMvpActivity
import com.example.employee.kotlin_shop_test.BaseLibrary.common.Constant.Companion.PERMISSION_CODE_FIRST
import com.example.employee.kotlin_shop_test.R
import com.example.employee.kotlin_shop_test.UserCenter.presenter.LoginPresenter
import com.example.employee.kotlin_shop_test.utils.PermissionUtils
import com.jph.takephoto.app.TakePhoto
import com.jph.takephoto.app.TakePhotoImpl
import com.jph.takephoto.compress.CompressConfig
import com.jph.takephoto.model.TResult
import com.kotlin.base.utils.DateUtils
import kotlinx.android.synthetic.main.activity_user_info.*
import java.io.File

class UserInfoActivity : BaseMvpActivity<LoginPresenter>(), View.OnClickListener, TakePhoto.TakeResultListener {

    lateinit var takePhoto: TakePhoto
    lateinit var mTempFile: File
    var isToast = false;
    private fun alertShow() {
        AlertView(
            null,
            "",
            "取消",
            null,
            arrayOf("拍照", "相册"),
            this,
            AlertView.Style.ActionSheet,
            object : OnItemClickListener {
                override fun onItemClick(o: Any?, position: Int) {

                    takePhoto.onEnableCompress(CompressConfig.ofDefaultConfig(), false)//启用图片压缩
                    when (position) {
                        //拍照
                        0 -> {
                            val checkPermissionFirst = PermissionUtils.checkPermissionFirst(
                                this@UserInfoActivity, PERMISSION_CODE_FIRST,
                                arrayOf(
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                    Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.CAMERA
                                )
                            )
                            if (checkPermissionFirst) {
                                createTempFile()//获取零时文件
                                takePhoto.onPickFromCapture(Uri.fromFile(mTempFile))
                            }


                        }
                        //相册
                        1 -> {
                            takePhoto.onPickFromGallery()
                        }
                    }
                }
            }).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        initView()
    }

    private fun initView() {
        mUserIconIv.setOnClickListener(this)
        takePhoto = TakePhotoImpl(this, this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mUserIconIv -> {
                alertShow()
            }
        }
    }

    override fun takeSuccess(result: TResult?) {
        Log.e("TAg", result?.image?.originalPath)
        Log.e("TAg", result?.image?.compressPath)
    }

    override fun takeCancel() {
    }

    override fun takeFail(result: TResult?, msg: String?) {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        takePhoto.onActivityResult(requestCode, resultCode, data)
    }


    fun createTempFile() {
        val tempFileName = "${DateUtils.curTime}.png"
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageDirectory())) {
            this.mTempFile = File(Environment.getExternalStorageDirectory(), tempFileName)
            return
        }
        this.mTempFile = File(filesDir, tempFileName)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        var isPermission = true
        for ((i, item) in permissions.withIndex()) {
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                isPermission = false
                //用户选择不再询问
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i])) {
                    if (isToast) {
                        Toast.makeText(this, "请手动打开该应用需要的权限", Toast.LENGTH_SHORT).show()
                        isToast = false
                    }
                }
            }
        }
        isToast = true
        if (isPermission) {
            createTempFile()//获取零时文件
            takePhoto.onPickFromCapture(Uri.fromFile(mTempFile))
        } else {
            Toast.makeText(this, "权限被拒绝", Toast.LENGTH_SHORT).show()
        }
    }
}
