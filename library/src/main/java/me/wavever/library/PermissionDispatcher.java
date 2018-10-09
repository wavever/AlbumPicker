package me.wavever.library;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class PermissionDispatcher {

    public static boolean check(Activity activity, SelectionCreator.Selecter selecter, boolean isCrop) {
        if (selecter == SelectionCreator.Selecter.ALBUM && isCrop) {
            return hasStoragePermission(activity);
        } else if (selecter == SelectionCreator.Selecter.CAMERA) {
            return hasStoragePermission(activity) && hasCameraPermission(activity);
        }
        return true;
    }

    private static boolean hasStoragePermission(Activity activity) {
        return ContextCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    private static boolean hasCameraPermission(Activity activity) {
        return ContextCompat.checkSelfPermission(activity,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    public static void request(Activity activity, SelectionCreator.Selecter selecter, boolean isCrop, int code) {
        if (selecter == SelectionCreator.Selecter.ALBUM && isCrop) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission_group.STORAGE}, code);
        } else if (selecter == SelectionCreator.Selecter.CAMERA) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission_group.STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, code);
        }
    }
}
