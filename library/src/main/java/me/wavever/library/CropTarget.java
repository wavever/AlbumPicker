package me.wavever.library;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class CropTarget extends BaseTarget {

    private Uri mSourceUri;
    private Uri mCropUri;
    private File mCropFile;

    public CropTarget uri(Context context, Uri sourceUri, Uri cropUri) {
        mSourceUri = convertUri(context, sourceUri);
        mCropUri = convertUri(context, cropUri);
        return this;
    }

    public CropTarget uri(Context context, Uri sourceUri) {
        Log.d("wavever_tag", "sourceUri="+sourceUri);
        mSourceUri = convertUri(context, sourceUri);
        Log.d("wavever_tag", "mSourceUri="+mSourceUri);
        File dir = new File(Environment.getExternalStorageDirectory(), File.separator+"AlbumPicker"+File.pathSeparator);
        if(!dir.exists()){
            dir.mkdir();
        }
        mCropFile = new File(dir, "crop.jpg");
        if(mCropFile.exists()){
            mCropFile.delete();
        }
        try {
            mCropFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mCropUri = Uri.fromFile(mCropFile);
        Log.d("wavever_tag", "mCropUri="+mCropUri);
        return this;
    }

    public CropTarget cropUri(Uri[] uri){
        uri[0] = mCropUri;
        return this;
    }

    public CropTarget cropFile(File[] file){
        file[0] = mCropFile;
        return this;
    }

    private Uri convertUri(Context context, Uri uri) {
        if (uri != null && uri.getScheme() != null && uri.getScheme().equals("content")) {
            String path = Utils.getFilePathFromUri(context, uri);
            return TextUtils.isEmpty(path) ? uri : Uri.fromFile(new File(path));
        }
        return uri;
    }

    @Override
    Intent createIntent() {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(mSourceUri, "image/*");
        Crop crop = new Crop();
        crop.decorateIntent(intent, mCropUri);
        return intent;
    }

}
