package me.wavever.library;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;

import java.lang.ref.WeakReference;

public class AlbumPicker {

    private WeakReference<Activity> mActivity;
    private WeakReference<Fragment> mFragment;

    private AlbumPicker(Activity activity, Fragment fragment) {
        mActivity = new WeakReference<>(activity);
        mFragment = new WeakReference<>(fragment);
    }

    public static AlbumPicker with(Activity activity) {
        return new AlbumPicker(activity, null);
    }

    public static AlbumPicker with(Fragment fragment) {
        return new AlbumPicker(fragment.getActivity(), fragment);
    }

    public Activity getActivity() {
        return mActivity.get();
    }

    public Fragment getFragment() {
        return mFragment.get();
    }

    public SelectionCreator fromAlbum() {
        return new SelectionCreator(this);
    }

    public SelectionCreator fromCamera() {
        return new SelectionCreator(this, SelectionCreator.Selecter.CAMERA);
    }

    public void crop(Uri uri, Uri cropUri, int cropCode) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        Crop crop = new Crop();
        crop.decorateIntent(intent, cropUri);
        if (getFragment() != null) {
            getFragment().startActivityForResult(intent, cropCode);
        } else if (getActivity() != null) {
            getActivity().startActivityForResult(intent, cropCode);
        }
    }

    public static String getFilePathFromUri(Uri uri) {
        return Utils.getFilePathFromUri(uri);
    }
}
