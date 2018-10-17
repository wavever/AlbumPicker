package me.wavever.library;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

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

    /**
     * 是否将bitmap作为data返回
     */
    private static final String RETURN_DATA = "return-data";

    /**
     * 是否圆形裁剪
     */
    private static final String CIRCLE_CROP = "circleCrop";

    /**
     * 输出裁剪后图片的uri
     */
    private static final String OUTPUT = MediaStore.EXTRA_OUTPUT;

    /**
     * 输出裁剪后图片的格式
     */
    private static final String OUTPUT_FORMAT = "outputFormat";

    /**
     * 是否脸部识别
     */
    private static final String NO_FACE_DETECTION = "noFaceDetection";

    private String mIsCrop;
    private int mAspectX;
    private int mAspectY;
    private int mOutputX;
    private int mOutputY;
    private boolean mIsScale;
    private boolean mIsReturnData;
    private boolean mIsCircleCrop;
    private String mOutputFormat;
    private boolean mIsNoFaceDetection;

    public Crop() {
        mIsCrop = "true";
        mAspectX = 1;
        mAspectY = 1;
        mOutputX = 300;
        mOutputY = 300;
        mIsScale = true;
        mIsReturnData = false;
        mIsCircleCrop = false;
        mOutputFormat = Bitmap.CompressFormat.JPEG.toString();
        mIsNoFaceDetection = true;
    }

    public void decorateIntent(Intent intent, Uri data) {
        intent.putExtra(CROP, mIsCrop);
        intent.putExtra(ASPECTX, mAspectX);
        intent.putExtra(ASPECTY, mAspectY);
        intent.putExtra(OUTPUTX, mOutputX);
        intent.putExtra(OUTPUTY, mOutputY);
        intent.putExtra(SCALE, mIsScale);
        intent.putExtra(RETURN_DATA, mIsReturnData);
        intent.putExtra(CIRCLE_CROP, mIsCircleCrop);
        intent.putExtra(OUTPUT, data);
        intent.putExtra(OUTPUT_FORMAT, mOutputFormat);
        intent.putExtra(NO_FACE_DETECTION, mIsNoFaceDetection);
    }

    public static class Builder {

        private Crop mCrop;

        Builder() {
            mCrop = new Crop();
        }

        public Builder isCrop(boolean isCrop) {
            mCrop.mIsCrop = String.valueOf(isCrop);
            return this;
        }

        public Builder aspectX(int aspectX) {
            mCrop.mAspectX = aspectX;
            return this;
        }

        public Builder aspectY(int aspectY) {
            mCrop.mAspectY = aspectY;
            return this;
        }

        public Builder outputX(int outputX) {
            mCrop.mOutputX = outputX;
            return this;
        }

        public Builder outputY(int outputY) {
            mCrop.mOutputY = outputY;
            return this;
        }

        public Builder isScale(boolean isScale) {
            mCrop.mIsScale = isScale;
            return this;
        }

        public Builder isReturnData(boolean isReturnData) {
            mCrop.mIsReturnData = isReturnData;
            return this;
        }

        public Builder isCircleCrop(boolean isCircleCrop) {
            mCrop.mIsCircleCrop = isCircleCrop;
            return this;
        }

        public Builder outputFormat(String outputFormat) {
            mCrop.mOutputFormat = outputFormat;
            return this;
        }

        public Builder isNoFaceDetection(boolean isNoFaceDetection) {
            mCrop.mIsNoFaceDetection = isNoFaceDetection;
            return this;
        }

        public Crop build() {
            return mCrop;
        }
    }
}
