# AlbumPicker

`AlbumPicker` is a library that you can get photo from album or camera very easy.

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

## TODO 

* add Permission Check.

## LICENCE

```
   Copyright [2018] [wavever]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```