# AlbumPicker

`AlbumPicker` is a library that you can get photo from album or camera.

## Usage

### Album
``` kotlin
AlbumPicker.pickAlbum()
           .allow(PERMISSION_REQUEST_CODE)
           .request(this, PICKER_REQUEST_CODE)
```

### Camear
``` kotlin
AlbumPicker.pickCamera(mPhotoUri)
           .allow(PERMISSION_REQUEST_CODE)
           .request(this, PICKER_REQUEST_CODE)
```

### Crop
``` kotlin
AlbumPicker.crop(uri, mUri)
           .allow(PERMISSION_REQUEST_CODE)
           .request(this, PICKER_REQUEST_CODE)
```