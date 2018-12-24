package me.wavever.library;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

public class AlbumPicker {

    private WeakReference<FragmentActivity> mActivity;
    private WeakReference<Fragment> mFragment;

    private AlbumPicker(FragmentActivity activity) {
        mActivity = new WeakReference<>(activity);
    }

    private AlbumPicker(Fragment fragment) {
        mFragment = new WeakReference<>(fragment);
    }

    public static AlbumPicker with(FragmentActivity activity) {
        return new AlbumPicker(activity);
    }

    public static AlbumPicker with(Fragment fragment) {
        return new AlbumPicker(fragment);
    }

    public AlbumPicker log(boolean enable){
        return log(enable, null);
    }

    public AlbumPicker log(boolean enable, String tag){
        PickerLog.enable(enable);
        PickerLog.tag(tag);
        return this;
    }

    public TargetBuilder from(PickerTarget target) {
        return new TargetBuilder(this, target);
    }

    FragmentActivity getActivity() {
        return mActivity == null ? null : mActivity.get();
    }

    Fragment getFragment() {
        return mFragment == null ? null : mFragment.get();
    }

}
