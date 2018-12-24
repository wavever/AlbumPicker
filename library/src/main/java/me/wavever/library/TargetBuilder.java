package me.wavever.library;

import android.support.v4.app.FragmentManager;

public class TargetBuilder {

    private PickerProxyFragment mFragment;

    public TargetBuilder(AlbumPicker picker, PickerTarget target) {
        FragmentManager fragmentManager = null;
        if (picker.getActivity() != null) {
            fragmentManager = picker.getActivity().getSupportFragmentManager();
        } else if (picker.getFragment() != null) {
            fragmentManager = picker.getFragment().getChildFragmentManager();
        }
        if (fragmentManager != null) {
            mFragment = (PickerProxyFragment) fragmentManager.findFragmentByTag(PickerProxyFragment.TAG);
            if (mFragment == null) {
                mFragment = PickerProxyFragment.getInstance();
            }
            fragmentManager
                    .beginTransaction()
                    .add(mFragment, PickerProxyFragment.TAG)
                    .commitNow();
        }
    }

    public TargetBuilder checkPermission() {
        return checkPermission(-1);
    }

    public TargetBuilder checkPermission(int requestCode) {
        return this;
    }

    public TargetBuilder crop() {
        return crop(new Crop());
    }

    public TargetBuilder crop(Crop crop) {
        return this;
    }

    public void start(PickerCallback callback) {

    }

}
