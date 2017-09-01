package com.cookie.bubble.custom;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by KimNaYeon on 9/1/2017.
 */

public class Filter {

    /**
     * Set Custom Filter to ImageView
     *
     * @param filter filter to set to ImageView
     * @param bitmap original bitmap
     * @return bitmap that custom filter invoked
     */
    private static Bitmap setFilter(ColorMatrix filter, Bitmap bitmap) {
        Bitmap result = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(filter));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return result;
    }

    /**
     * Adjust ImageView's Contrast : maxValue : 100, start from 50
     *
     * @param bitmap   original bitmap
     * @param progress seekbar's progress value : 0 ~ 10, 1 is default
     * @return bitmap that contrast invoked
     */
    public static Bitmap adjustContrast(Bitmap bitmap, int progress) {
        if (progress > 50) {
            double contrast = 1 + (0.045 * (progress - 50));
            ColorMatrix filter = new ColorMatrix(new float[]{
                    (float) contrast, 0, 0, 0, 0,
                    0, (float) contrast, 0, 0, 0,
                    0, 0, (float) contrast, 0, 0,
                    0, 0, 0, 1, 0
            });
            return setFilter(filter, bitmap);
        } else if (progress < 50) {
            double contrast = 0.3 + (0.02 * progress);
            if (contrast > 1) {
                return bitmap;
            } else {
                ColorMatrix filter = new ColorMatrix(new float[]{
                        (float) contrast, 0, 0, 0, 0,
                        0, (float) contrast, 0, 0, 0,
                        0, 0, (float) contrast, 0, 0,
                        0, 0, 0, 1, 0
                });
                return setFilter(filter, bitmap);
            }
        } else {
            return bitmap;
        }
    }


    /**
     * Adjust ImageView's Brightness : maxValue : 100, start from 50
     *
     * @param bitmap   original bitmap
     * @param progress seekbar's progress value : ~255 ~ 255, 0 is default
     * @return bitmap that brightness invoked
     */
    public static Bitmap adjustBrightness(Bitmap bitmap, int progress) {
        if (progress != 50) {
            double brightness = 3.0 * (progress - 50);
            ColorMatrix filter = new ColorMatrix(new float[]{
                    1, 0, 0, 0, (float) brightness,
                    0, 1, 0, 0, (float) brightness,
                    0, 0, 1, 0, (float) brightness,
                    0, 0, 0, 1, (float) brightness
            });
            return setFilter(filter, bitmap);
        } else {
            return bitmap;
        }
    }

    /**
     * Adjust ImageView's Grayscale : maxValue : 50, start from 0
     *
     * @param bitmap   original bitmap
     * @param progress seekbar's progress value : 0 ~ 1, 0 is default
     * @return bitmap that grayScale invoked
     */
    public static Bitmap grayScale(Bitmap bitmap, int progress) {
        ColorMatrix filter = new ColorMatrix(new float[]{
                1, 0, 0, 0, 0,
                0, 1, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0
        });
        if (progress != 0 && progress < 50) {
            double saturation = 1 - (0.02 * progress);
            filter.setSaturation((float) saturation);
            return setFilter(filter, bitmap);
        } else {
            if (progress == 0) {
                return bitmap;
            } else {
                filter.setSaturation(0.0f);
                return setFilter(filter, bitmap);
            }
        }
    }

    /**
     * Adjust ImageView's Hue : maxValue : 360, start from 0
     *
     * @param bitmap   which bitmap to convert
     * @param progress seekbar's progress value : 0 ~ 360, 0 is default
     * @return bitmap with new hue values
     */
//    public static Bitmap adjustHue(Bitmap bitmap, int progress) {
//        Bitmap newBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
//        int width = newBitmap.getWidth();
//        int height = newBitmap.getHeight();
//        float[] hvs = new float[3];
//
//        for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                int pixel = newBitmap.getPixel(x, y);
//                Color.colorToHSV(pixel, hvs);
//                hvs[0] = progress;
//                newBitmap.setPixel(x, y, Color.HSVToColor(Color.alpha(pixel), hvs));
//            }
//        }
//        return newBitmap;
//    }


    /**
     * Adjust  ImageView's color temperature maxValue : 200, start from 100
     *
     * @param bitmap   original bitmap
     * @param progress seekbar's progress value : -100 ~ 100, 0 is default
     * @return bitmap that custom temperature invoked
     */
    public static Bitmap adjustTemperature(Bitmap bitmap, int progress) {
//        int red;
//        int green;
//        int blue;
//
//        if (progress > 100) {
//            red = 255;
//            green = (int) (249 - (1.93 * (progress - 100)));
//            if (progress > 180) {
//                blue = 0;
//            } else {
//                blue = (int) (253 - (2.42 * (progress - 100)));
//            }
//
//            Log.i(Filter.class.getSimpleName(), " >>>>>> RED : " + red + ", GREEN : " + green + ", BLUE : " + blue);
//
//            ColorMatrix filter = new ColorMatrix(new float[]{
//                    red / 255.0f, 0, 0, 0, 0,
//                    0, green / 255.0f, 0, 0, 0,
//                    0, 0, blue / 255.0f, 0, 0,
//                    0, 0, 0, 1, 0
//            });
//
//            return setFilter(filter, bitmap);
//        } else if (progress < 100) {
//            // red : 254 ~ 155 : 99
//            // green : 249 ~ 188 : 61
//            // blue : 255 ~ 255 : 0
//
//
//
//            blue = 255;
//
//            return bitmap;
//        } else {
//            return bitmap;
//        }
//    }
        return null;
    }

    public static Bitmap saveHighlight(Bitmap bitmap, int progress) {


        return null;
    }

    public static Bitmap saveShadow(Bitmap bitmap, int progress) {

        return null;
    }
}
