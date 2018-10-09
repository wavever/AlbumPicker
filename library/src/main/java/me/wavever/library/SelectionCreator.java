package me.wavever.library;

import android.content.Intent;
import android.os.Build;
import android.provider.MediaStore;

public class SelectionCreator {

    private AlbumPicker mPicker;
    private Selecter mSelecter;
    private boolean mIsVersionM;
    private Intent mIntent;
    private boolean mHasPermission = true;

    SelectionCreator(AlbumPicker picker) {
        this(picker, Selecter.ALBUM);
    }

    SelectionCreator(AlbumPicker picker, Selecter selecter) {
        mPicker = picker;
        mSelecter = selecter;
        mIsVersionM = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
        mIntent = new Intent();
        if (selecter == Selecter.CAMERA && Utils.hasCamera(picker.getActivity().getPackageManager())) {
            mIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        } else {
            mIntent.setAction(Intent.ACTION_GET_CONTENT);
            mIntent.setType("image/*");
        }
    }

    public SelectionCreator checkPremission(int requestCode, boolean isCrop) {
        if (mPicker.getActivity() != null && mIsVersionM
                && !PermissionDispatcher.check(mPicker.getActivity(), mSelecter, isCrop)) {
            mHasPermission = false;
            PermissionDispatcher.request(mPicker.getActivity(), mSelecter, isCrop, requestCode);
        }
        return this;
    }

    public void pick(int requestCode) {
        if (mPicker != null && mHasPermission) {
            if (mPicker.getFragment() != null) {
                mPicker.getFragment().startActivityForResult(mIntent, requestCode);
            } else if (mPicker.getActivity() != null) {
                mPicker.getActivity().startActivityForResult(mIntent, requestCode);
            }
        }
    }

    enum Selecter {

        ALBUM(0),
        CAMERA(1);

        final int select;

        Selecter(int select) {
            this.select = select;
        }

    }
}
