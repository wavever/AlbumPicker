package me.wavever.library;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

public abstract class BaseTarget {

    abstract Intent createIntent();

    public void request(Activity activity, int requestCode){
        activity.startActivityForResult(createIntent(), requestCode);
    }

    public void request(Fragment fragment, int requestCode){
        fragment.startActivityForResult(createIntent(), requestCode);
    }
}
