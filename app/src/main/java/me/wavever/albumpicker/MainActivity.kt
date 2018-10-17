package me.wavever.albumpicker

import android.app.Activity
import android.app.AlertDialog
import android.content.ContentProvider
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import me.wavever.library.AlbumPicker
import java.io.File

class MainActivity : AppCompatActivity() {

    private val CODE_REQUEST_ALBUM: Int = 2008
    private val CODE_REQUEST_CAMERA: Int = 2009
    private val CODE_REQUEST_CROP: Int = 2010

    private var mPath = arrayOfNulls<String>(1)
    private var mPhoto = arrayOfNulls<File>(1)
    private var mCrop = arrayOfNulls<File>(1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pick.setOnClickListener {
            AlertDialog.Builder(this).setItems(arrayOf("相册", "相机"))
            { _, which ->
                if (which == 0) {
                    pickFromAlbum()
                } else {
                    pickFromCamera()
                }
            }.create().apply { show() }
        }
    }

    private fun pickFromAlbum() {
        AlbumPicker.fromAlbum().request(this, CODE_REQUEST_ALBUM)
    }

    private fun pickFromCamera() {
        AlbumPicker.fromCamera().photo(mPhoto).request(this, CODE_REQUEST_CAMERA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if(requestCode == CODE_REQUEST_ALBUM){
                AlbumPicker.fromCrop()
                        .uri(applicationContext, data!!.data)
                        .cropFile(mCrop)
                        .request(this, CODE_REQUEST_CROP)
            }else if(requestCode == CODE_REQUEST_CAMERA){
                AlbumPicker.fromCrop()
                        .uri(applicationContext, Uri.fromFile(mPhoto[0]))
                        .cropFile(mCrop)
                        .request(this, CODE_REQUEST_CROP)
            }else if(requestCode == CODE_REQUEST_CROP){
                pickerImgView.setImageBitmap(BitmapFactory.decodeFile(mCrop[0]!!.absolutePath))
            }
        }
    }

}
