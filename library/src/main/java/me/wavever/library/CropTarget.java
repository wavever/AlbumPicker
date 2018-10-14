package me.wavever.library;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;

public class CropTarget implements ITarget {

    private Intent mIntent;
    private Uri mSourceUri;
    private Uri mCropUri;
    private PermissionDispatcher mPermissionDispatcher;

    CropTarget(Uri sourceUri, Uri cropUri) {
        this(sourceUri, cropUri, new Crop());
    }

    CropTarget(Uri sourceUri, Uri cropUri, Crop crop){
        mIntent = crop.buildIntent(sourceUri, cropUri);
    }

    @Override
    public ITarget allow(int requestCode) {
        mPermissionDispatcher = new PermissionDispatcher(requestCode);
        return this;
    }

    @Override
    public void request(Activity activity, int requestCode) {
        if (activity != null) {
            checkPermission(activity);
            activity.startActivityForResult(mIntent, requestCode);
        }
    }

    @Override
    public void request(Fragment fragment, int requestCode) {
        if (fragment != null) {
            checkPermission(fragment.getActivity());
            fragment.startActivityForResult(mIntent, requestCode);
        }
    }

    private void checkPermission(Activity activity) {
        mPermissionDispatcher.check(activity, Target.CROP);
    }
}
