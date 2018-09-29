package me.wavever.library;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class SelectionCreator {

    private Selecter mSelecter;
    private WeakReference<Activity> mActivity;
    private Crop mCrop;
    private boolean mIsVersionM;
    private PermissionDispatcher mPermissionDispatcher;

    SelectionCreator(Activity activity) {
        this(activity, Selecter.ALBUM);
    }

    SelectionCreator(Activity activity, Selecter selecter) {
        mActivity = new WeakReference<>(activity);
        mSelecter = selecter;
        mIsVersionM = Build.VERSION.SDK_INT >= 23;
    }

    public SelectionCreator crop(Crop crop) {
        mCrop = crop;
        return this;
    }

    @TargetApi(23)
    public SelectionCreator checkPremission(int requestCode) {
        if (mActivity.get() != null && mIsVersionM){
            mPermissionDispatcher = new PermissionDispatcher(mActivity.get(), requestCode, mSelecter);
        }
        return this;
    }

    enum Selecter {

        ALBUM(0),
        CAMERA(1),
        ALL(2);

        final int select;

        Selecter(int select) {
            this.select = select;
        }

    }
}
