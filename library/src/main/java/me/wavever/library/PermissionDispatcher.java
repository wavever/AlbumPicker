package me.wavever.library;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.M)
public class PermissionDispatcher {


    PermissionDispatcher(Activity activity, int requestCode, SelectionCreator.Selecter selecter) {
        requestPermission(activity, requestCode, selecter);
    }

    private void requestPermission(Activity activity, int requestCode, SelectionCreator.Selecter selecter) {
        if (selecter == SelectionCreator.Selecter.ALBUM) {
            //TODO check crop != null
            boolean hasStoragePermission = ContextCompat.checkSelfPermission(activity,
                    Manifest.permission_group.STORAGE) == PackageManager.PERMISSION_GRANTED;
            if (!hasStoragePermission) {
                activity.requestPermissions(new String[]{Manifest.permission_group.STORAGE}, requestCode);
            }
        } else if (selecter == SelectionCreator.Selecter.CAMERA) {
            boolean hasStoragePermission = ContextCompat.checkSelfPermission(activity,
                    Manifest.permission_group.STORAGE) == PackageManager.PERMISSION_GRANTED;
            boolean hasCameraPermission = ContextCompat.checkSelfPermission(activity,
                    Manifest.permission_group.CAMERA) == PackageManager.PERMISSION_GRANTED;
            List<String> permissionsList = new ArrayList<>(2);
            if (!hasStoragePermission) {
                permissionsList.add(Manifest.permission_group.STORAGE);
            }
            if (!hasCameraPermission) {
                permissionsList.add(Manifest.permission_group.CAMERA);
            }
            if (!permissionsList.isEmpty()) {
                String[] permissionsArray = permissionsList.toArray(new String[]{});
                activity.requestPermissions(permissionsArray, requestCode);
            }
        }
    }

    public static boolean checkPermission(SelectionCreator.Selecter selecter){
        return false;
    }

    interface OnCheckPermissonListener {
        void onGranted();

        void onDenied();
    }

}
