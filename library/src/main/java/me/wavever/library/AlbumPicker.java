package me.wavever.library;

import android.app.Activity;
import android.support.v4.app.Fragment;

import java.lang.ref.WeakReference;

public class AlbumPicker {

    private WeakReference<Activity> mActivity;
    private WeakReference<Fragment> mFragment;

    private AlbumPicker(Activity activity, Fragment fragment) {
        mActivity = new WeakReference<>(activity);
        mFragment = new WeakReference<>(fragment);
    }

    public static AlbumPicker with(Activity activity) {
        return new AlbumPicker(activity, null);
    }

    public static AlbumPicker with(Fragment fragment) {
        return new AlbumPicker(fragment.getActivity(), fragment);
    }

    private Activity getActivity() {
        return mActivity.get();
    }

    private Fragment getFragment() {
        return mFragment.get();
    }

    public SelectionCreator fromAlbum() {
        return new SelectionCreator(getActivity());
    }

    public SelectionCreator fromCamera() {
        return new SelectionCreator(getActivity(), SelectionCreator.Selecter.CAMERA);
    }

    public SelectionCreator fromAll() {
        return new SelectionCreator(getActivity(), SelectionCreator.Selecter.ALL);
    }

}
