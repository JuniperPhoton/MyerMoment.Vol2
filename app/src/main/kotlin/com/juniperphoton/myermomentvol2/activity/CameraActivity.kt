package com.juniperphoton.myermomentvol2.activity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.juniperphoton.myermomentvol2.R
import com.juniperphoton.myermomentvol2.util.Logger
import com.juniperphoton.myermomentvol2.widget.AutoFitTextureView
import kotlinx.android.synthetic.main.activity_main.*

class CameraActivity : BaseActivity() {
    companion object {
        private const val PERMISSION_REQUEST_CODE = 100
        private const val TAG = "CameraActivity"
    }

    private val textureView: AutoFitTextureView by lazy {
        preview_texture
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        if (requestCameraPermission()) {
            openCamera()
        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE
                && permissions[0] == Manifest.permission.CAMERA
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openCamera()
        } else {
            Logger.debug(TAG, "can't get camera permission")
            //todo: show hint for not getting permission successfully
        }
    }

    private fun requestCameraPermission(): Boolean {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), PERMISSION_REQUEST_CODE)
            return false
        }
        return true
    }

    private fun openCamera() {

    }
}