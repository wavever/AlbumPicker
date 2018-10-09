package me.wavever.library;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.List;

public class Utils {

    public static boolean hasCamera(PackageManager manager){
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        List<ResolveInfo> infos = manager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return infos != null && !infos.isEmpty();
    }

    public static String getFilePathFromUri(Uri uri){
        return "";
    }
}
