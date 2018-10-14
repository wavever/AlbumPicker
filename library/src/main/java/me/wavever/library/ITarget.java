package me.wavever.library;

import android.app.Activity;
import android.support.v4.app.Fragment;

public interface ITarget {

    /**
     * check if app has permission, if not, to request.
     * @param requestCode the code to request permission.
     * @return ITarget
     */
    ITarget allow(int requestCode);

    void request(Activity activity, int requestCode);

    void request(Fragment fragment, int requestCode);
}
