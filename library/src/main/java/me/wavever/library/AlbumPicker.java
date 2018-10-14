package me.wavever.library;

import android.net.Uri;

public class AlbumPicker {

    public static ITarget pickAlbum() {
        return new AlbumTarget();
    }

    public static ITarget pickCamera(Uri uri) {
        return new CameraTarget(uri);
    }

    public static ITarget crop(Uri sourceUri, Uri cropUri) {
        return new CropTarget(sourceUri, cropUri);
    }

    public static ITarget crop(Uri sourceUri, Uri cropUri,Crop crop) {
        return new CropTarget(sourceUri, cropUri,crop);
    }

    public static String getFilePathFromUri(Uri uri) {
        return Utils.getFilePathFromUri(uri);
    }
}
