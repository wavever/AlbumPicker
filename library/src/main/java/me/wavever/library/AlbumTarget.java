package me.wavever.library;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

public class AlbumTarget implements ITarget {

    private Intent mIntent;
    private PermissionDispatcher mPermissionDispatcher;

    AlbumTarget() {
        mIntent = new Intent(Intent.ACTION_GET_CONTENT);
        mIntent.setType("image/*");
    }

    @Override
    public ITarget allow(int requestCode) {
        mPermissionDispatcher = new PermissionDispatcher(requestCode);
        return this;
    }

    @Override
    public void request(Activity activity, int requestCode) {
        if(activity != null){
            mPermissionDispatcher.check(activity, Target.ALBUM);
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
