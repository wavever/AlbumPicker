package me.wavever.library;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public class PickerProxyFragment extends Fragment {

    public static final String TAG = "PickerProxyFragment";

    private static final int CODE_REQUEST_PERMISSION = 1;
    private static final int CODE_REQUEST_ALBUM = 2;
    private static final int CODE_REQUEST_CAMERA = 3;
    private static final int CODE_REQUEST_CROP = 4;

    private int mRequestPermissionCode = CODE_REQUEST_PERMISSION;

    private PermissionDispatcher mPermissionDispatcher;
    private Crop mCrop;

    public static PickerProxyFragment getInstance(){
        return new PickerProxyFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPermissionDispatcher = new PermissionDispatcher(mRequestPermissionCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
