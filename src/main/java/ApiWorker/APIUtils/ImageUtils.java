package ApiWorker.APIUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

import classifieds.yalla.logger.MyLogger;

/**
 * Created by artem on 4/15/15.
 */
public class ImageUtils {

    public static final String TAG = ImageUtils.class.getSimpleName();

    private static final int WIDTH_FROM_UPLOAD = 700;
    private static final int HEIGHT_FROM_UPLOAD = 475;

    private static final String CACHE_DIR_NAME = "images";

    private static final String RESIZED_IMAGE_PREFIX_NAME = "ad_image_number_";

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static int getImageOrientation(String imagePath) {

        int rotate = 0;
        try {

            File imageFile = new File(imagePath);
            ExifInterface exif = new ExifInterface(
                    imageFile.getAbsolutePath());
            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);

            switch (orientation) {

                case ExifInterface.ORIENTATION_ROTATE_270:

                    rotate = 270;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:

                    rotate = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_90:

                    rotate = 90;
                    break;
            }
        } catch (Throwable th) {

            MyLogger.e(TAG, "Failed to getImageOrientation!", th);
        }

        return rotate;
    }

    private static Bitmap rotateBitmap(Bitmap bitmap, String imageFilePath) {

        int orientation = getImageOrientation(imageFilePath);

        Bitmap rotatedBitmap = null;
        if (bitmap != null) {

            try {

                Matrix matrix = new Matrix();
                matrix.postRotate(orientation);
                rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                        bitmap.getHeight(), matrix, true);
            } catch (Throwable th) {

                MyLogger.e(TAG, "Failed to rotate bitmap", th);
            } finally {

                if (rotatedBitmap != bitmap && !bitmap.isRecycled()) {

                    bitmap.recycle();
                }
            }
        }

        return rotatedBitmap;
    }

    private static String saveImageIntoDiskCache(File cacheDir, String fileName, Bitmap bitmap) {

        File imagesCacheDir = new File(cacheDir, CACHE_DIR_NAME);

        if (!imagesCacheDir.exists())
            imagesCacheDir.mkdir();

        File cacheFile = new File(imagesCacheDir, fileName);
        try {

            if (!cacheFile.exists())
                cacheFile.createNewFile();

            FileOutputStream fos = new FileOutputStream(cacheFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fos);

            fos.flush();
            fos.close();
        } catch (Exception e) {

            MyLogger.e(TAG, "Error when saving image to cache. ", e);
        }

        return cacheFile.getAbsolutePath();
    }

    public static String getNameForResizeImageFilePath(int imageNum) {

        return RESIZED_IMAGE_PREFIX_NAME + imageNum;
    }

    public static String getResizedImageForUpload(File cacheDir, String imageFilePath, int imageNum) {

        String resizedImageFilePath = null;
        Bitmap bitmap = null;
        try {

            if (!TextUtils.isEmpty(imageFilePath)) {

                BitmapFactory.Options bmOptions = new BitmapFactory.Options();
                bmOptions.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(imageFilePath, bmOptions);

                int scaleFactor = calculateInSampleSize(bmOptions, WIDTH_FROM_UPLOAD, HEIGHT_FROM_UPLOAD);

                if (scaleFactor > 1) {

                    bmOptions.inJustDecodeBounds = false;
                    bmOptions.inSampleSize = scaleFactor;
                    bmOptions.inPurgeable = true;

                    bitmap = rotateBitmap(BitmapFactory.decodeFile(imageFilePath, bmOptions), imageFilePath);
                } else
                    bitmap = rotateBitmap(BitmapFactory.decodeFile(imageFilePath), imageFilePath);

                if (bitmap != null)
                    resizedImageFilePath = saveImageIntoDiskCache(cacheDir, getNameForResizeImageFilePath(imageNum), bitmap);
            }
        } catch (Throwable th) {

            MyLogger.e(TAG, "failed to getResizedImageForUpload", th);
        } finally {

            if (bitmap != null && !bitmap.isRecycled())
                bitmap.recycle();
            bitmap = null;
        }

        return resizedImageFilePath;
    }
}
