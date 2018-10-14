package me.wavever.library;

public enum Target {
    ALBUM(0),
    CAMERA(1),
    CROP(2);

    final int select;

    Target(int select) {
        this.select = select;
    }

}
