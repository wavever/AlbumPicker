package me.wavever.library;

import android.app.Activity;
import android.support.v4.app.Fragment;

public interface ITarget {

    ITarget allow(int requestCode);

    void request(Activity activity, int requestCode);

    void request(Fragment fragment, int requestCode);
}
