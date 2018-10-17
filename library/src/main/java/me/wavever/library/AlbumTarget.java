package me.wavever.library;

import android.content.Intent;

public class AlbumTarget extends BaseTarget {

    private PermissionDispatcher mPermissionDispatcher;

    @Override
    Intent createIntent() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        return intent;
    }
}
