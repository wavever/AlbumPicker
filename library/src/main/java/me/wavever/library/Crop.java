package me.wavever.library;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;

public class Crop {

    /**
     * 是否裁剪
     */
    private static final String CROP = "crop";

    /**
     * 裁剪框X轴比例
     */
    private static final String ASPECTX = "aspectX";

    /**
     * 裁剪框Y轴比例
     */
    private static final String ASPECTY = "aspectY";

    /**
     * 裁剪框宽度
     */
    private static final String OUTPUTX = "outputX";

    /**
     * 裁剪框高度
     */
    private static final String OUTPUTY = "outputY";

    /**
     * 是否保留比例
     */
    private static final String SCALE = "scale";
    private static final String RETURN_DATA = "return-data";
    private static final String CIRCLE_CROP = "circleCrop";
    private static final String OUTPUT = "output";
    private static final String OUTPUT_FORMAT = "outputFormat";
    private static final String NO_FACE_DETECTION = "noFaceDetection";

    private boolean mCrop;
    private int mAspectX;
    private int mAspectY;
    private int mOutputX;
    private int mOutputY;
    private boolean mScale;
    private boolean mReturnData;
    private boolean mCircleCrop;
    private Uri mPhotoData;
    private String mOutputFormat;
    private boolean mNoFaceDetection;

    public Crop(){
        mCrop = true;
        mAspectX = 1;
        mAspectY = 1;
        mOutputX = 200;
        mOutputY = 200;
        mScale = true;
        mReturnData = false;
        mCircleCrop = false;
        mOutputFormat = Bitmap.CompressFormat.JPEG.toString();
        mNoFaceDetection = false;
    }

    public void decorateIntent(Intent intent){
        intent.putExtra(CROP, mCrop);
        intent.putExtra(ASPECTX,mAspectX);
        intent.putExtra(ASPECTY, mAspectY);
        intent.putExtra(OUTPUTX, mOutputX);
        intent.putExtra(OUTPUTY, mOutputY);
        intent.putExtra(SCALE, mScale);
        intent.putExtra(RETURN_DATA, mReturnData);
        intent.putExtra(CIRCLE_CROP, mCircleCrop);
        intent.putExtra(OUTPUT_FORMAT, mOutputFormat);
        intent.putExtra(NO_FACE_DETECTION, mNoFaceDetection);
    }

    public Intent buildIntent(){
        Intent intent = new Intent();
        decorateIntent(intent);
        return intent;
    }
}
