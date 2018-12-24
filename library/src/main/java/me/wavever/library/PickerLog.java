package me.wavever.library;

import android.util.Log;

public class PickerLog {

    private static String TAG = "AlbumPicker";
    private static String sTag = "";

    private static boolean sEnable = BuildConfig.DEBUG;

    public static void enable(boolean enable) {
        sEnable = enable;
    }

    public static void tag(String tag) {
        if (tag != null) {
            sTag = tag;
        }
    }

    public void v(String msg) {
        if (sEnable) {
            Log.v(TAG, sTag + "" + msg);
        }
    }

    public void d(String msg) {
        if (sEnable) {
            Log.d(TAG, sTag + "" + msg);
        }
    }

    public void i(String msg) {
        if (sEnable) {
            Log.i(TAG, sTag + "" + msg);
        }
    }

    public void w(String msg) {
        if (sEnable) {
            Log.w(TAG, sTag + "" + msg);
        }
    }

    public void e(String msg) {
        if (sEnable) {
            Log.e(TAG, sTag + "" + msg);
        }
    }

}
