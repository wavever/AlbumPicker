package me.wavever.library;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class PermissionDispatcher {

    private int mRequestCode;

    PermissionDispatcher(int requestCode) {
        mRequestCode = requestCode;
    }

    public boolean check(Activity activity, Target target) {
        if (target == Target.ALBUM || target == Target.CROP) {
            if (!hasStoragePermission(activity)) {
                request(activity, target);
                return false;
            }
        } else if (target == Target.CAMERA) {
            if (hasStoragePermission(activity) && hasCameraPermission(activity)) {
                request(activity, target);
                return false;
            }
        }
        return true;
    }

    private boolean hasStoragePermission(Activity activity) {
        return ContextCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    private boolean hasCameraPermission(Activity activity) {
        return ContextCompat.checkSelfPermission(activity,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    private void request(Activity activity, Target target) {
        if (target == Target.ALBUM) {
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission_group.STORAGE}, mRequestCode);
        } else if (target == Target.CAMERA) {
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission_group.STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, mRequestCode);
        } else {
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission_group.STORAGE}, mRequestCode);
        }
    }
}
