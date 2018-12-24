package me.wavever.albumpicker

import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import me.wavever.library.AlbumPicker
import me.wavever.library.PickerCallback
import me.wavever.library.PickerResult
import me.wavever.library.PickerTarget

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pick.setOnClickListener {
            AlertDialog.Builder(this).setItems(arrayOf(getString(R.string.album_title), getString(R.string.camera_title)))
            { _, which ->
                AlbumPicker.with(this)
                        .from(if (which == 0) PickerTarget.ALBUM else PickerTarget.CAMERA)
                        .crop()
                        .checkPermission()
                        .start(object : PickerCallback {
                            override fun onPick(result: PickerResult?) {
                                pickerPathView.text = result?.file?.absolutePath
                                pickerUriView.text = result?.uri?.toString()
                            }

                            override fun onFailed() {
                                pickerPathView.text = getString(R.string.camera_title)
                            }

                        })
            }.create().apply { show() }
        }
    }

}
