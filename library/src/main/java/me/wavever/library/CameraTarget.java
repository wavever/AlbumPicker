package me.wavever.library;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;

public class CameraTarget implements ITarget{

    private Intent mIntent;
    private PermissionDispatcher mPermissionDispatcher;

    CameraTarget(Uri photoUri){
        mIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        mIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
    }

    @Override
    public ITarget allow(int requestCode) {
        mPermissionDispatcher = new PermissionDispatcher(requestCode);
        return this;
    }

    @Override
    public void request(Activity activity, int requestCode) {
        if(activity != null && mPermissionDispatcher.check(activity, Target.CAMERA)){
            activity.startActivityForResult(mIntent, requestCode);
        }
    }

    @Override
    public void request(Fragment fragment, int requestCode) {
        if(fragment != null){
            request(fragment.getActivity(), requestCode);
        }
    }
}
