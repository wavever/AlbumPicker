package me.wavever.library;

public enum PickerTarget {

    ALBUM(0),

    CAMERA(1);

    final int select;

    PickerTarget(int select) {
        this.select = select;
    }
}
