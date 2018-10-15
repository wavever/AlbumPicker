package me.wavever.albumpicker

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import me.wavever.library.AlbumPicker
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    val PERMISSION_REQUEST_CODE: Int = 2008
    val PICKER_REQUEST_CODE: Int = 2009
    val CROP_REQUEST_CODE: Int = 2010

    private var mUri: Uri? = null
    private var mPath: String? = null
    private var mPhotoUri : Uri ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val file: File = File(Environment.getExternalStorageDirectory(), File.pathSeparator + "Demo.jpg")
        val photoName : String = SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(Date())+"_demo.jpg"
        val photo : File = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), photoName)
        mPhotoUri = Uri.fromFile(photo)
        mUri = Uri.fromFile(file)
        mPath = file.absolutePath
        Log.d("wavever_tag", "mPath=$mPath, mUri=$mUri")
        pick.setOnClickListener {
            val dialog: AlertDialog = AlertDialog.Builder(this).setItems(arrayOf("相册", "相机"))
            { dialog, which ->
                if (which == 0) {
                    pickFromAlbum()
                } else {
                    pickFromCamera()
                }
            }.create()
            dialog.show()
        }
    }

    private fun pickFromAlbum() {
        AlbumPicker.pickAlbum()
                .allow(PERMISSION_REQUEST_CODE)
                .request(this, PICKER_REQUEST_CODE)
    }

    private fun pickFromCamera() {
        AlbumPicker.pickCamera(mPhotoUri)
                .allow(PERMISSION_REQUEST_CODE)
                .request(this, PICKER_REQUEST_CODE)
    }

    private fun crop(uri: Uri) {
        AlbumPicker.crop(uri, mUri)
                .allow(PERMISSION_REQUEST_CODE)
                .request(this, CROP_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == PICKER_REQUEST_CODE && data != null) {
                Log.d("wavever_tag", "data.uri=${data.data}")
                crop(data.data)
            } else if (requestCode == CROP_REQUEST_CODE) {
                pickerImgView.setImageBitmap(BitmapFactory.decodeFile(mPath))
            }
        }
    }

}
