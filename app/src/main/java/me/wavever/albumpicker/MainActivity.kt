package me.wavever.albumpicker

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import me.wavever.library.AlbumPicker

class MainActivity : AppCompatActivity() {

    val PERMISSION_REQUEST_CODE: Int = 2008
    val PICKER_REQUEST_CODE: Int = 2009
    val CROP_REQUEST_CODE: Int = 2009

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pickAlbum.setOnClickListener {
            pickFromAlbum()
        }

        pickCamera.setOnClickListener {
            pickFromCamera()
        }
    }

    private fun pickFromAlbum() {
        AlbumPicker.with(this)
                .fromAlbum()
                .checkPremission(PERMISSION_REQUEST_CODE, true)
                .pick(PICKER_REQUEST_CODE)
    }

    private fun pickFromCamera() {
        AlbumPicker.with(this)
                .fromCamera()
                .checkPremission(PERMISSION_REQUEST_CODE, true)
                .pick(PICKER_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == PICKER_REQUEST_CODE) {
                AlbumPicker.with(this).crop(data?.data, null, CROP_REQUEST_CODE)
            } else if (requestCode == CROP_REQUEST_CODE) {
                //TODO
            }
        }
    }

}
