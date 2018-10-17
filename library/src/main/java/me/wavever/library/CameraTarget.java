package me.wavever.library;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CameraTarget extends BaseTarget {

    private File mPhoto;

    CameraTarget() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        try {
            mPhoto = File.createTempFile(
                    imageFileName,  /* prefix */
                    ".jpg",   /* suffix */
                    storageDir     /* directory */
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CameraTarget path(String[] path) {
        if (path != null && path.length > 1 && mPhoto != null) {
            path[0] = mPhoto.getAbsolutePath();
        }
        return this;
    }

    public CameraTarget photo(File[] photo) {
        if (photo != null && photo.length > 1 && mPhoto != null) {
            photo[0] = mPhoto;
        }
        return this;
    }

    @Override
    Intent createIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mPhoto));
        return intent;
    }
}
