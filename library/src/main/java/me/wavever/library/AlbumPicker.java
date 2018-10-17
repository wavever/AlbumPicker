package me.wavever.library;

public class AlbumPicker {

    public static CameraTarget fromCamera() {
        return new CameraTarget();
    }

    public static AlbumTarget fromAlbum(){
        return new AlbumTarget();
    }

    public static CropTarget fromCrop() {
        return new CropTarget();
    }

}
