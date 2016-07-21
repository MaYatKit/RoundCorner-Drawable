package com.example.yijiema.roundcornerdrawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by yijie.ma on 2016/7/20.
 */
public class RoundCornerDrawable extends Drawable{

    protected final float cornerRadius;
    protected final int margin;

    protected RectF mRect = new RectF();
    protected final BitmapShader bitmapShader;
    protected final Paint paint;
    protected Bitmap mBitmap;

    private Type mType = Type.fitXY;


    public enum Type {
        center, fitXY, centerCrop
    }

    public RoundCornerDrawable(Bitmap bitmap, int cornerRadius, int margin, Type type) {
        this.cornerRadius = cornerRadius;
        this.margin = margin;
        mBitmap = bitmap;
        mType = type;

        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        mRect.set(margin, margin, bounds.width() - margin, bounds.height() - margin);

        Matrix shaderMatrix = new Matrix();
        int width = bounds.width();
        int height = bounds.height();

        switch (mType){
            case centerCrop:
                float scale = width * 1.0f / mBitmap.getWidth();
                if (scale * mBitmap.getHeight() < height) {
                    scale = height * 1.0f / mBitmap.getHeight();
                }
                int outWidth = Math.round(scale * mBitmap.getWidth());
                int outHeight = Math.round(scale * mBitmap.getHeight());

                shaderMatrix.postScale(scale, scale);

                int left = 0;
                int top = 0;
                if (outWidth == width) {
                    top = (outHeight - height) * -1 / 2;
                }else {
                    left = (outWidth - width) * -1 / 2;
                }
                shaderMatrix.postTranslate(left, top);
                break;
            case fitXY:
                float wScale = width * 1.0f / mBitmap.getWidth();
                float hScale = height * 1.0f / mBitmap.getHeight();
                shaderMatrix.postScale(wScale, hScale);
                break;
            case center:
                int moveleft;
                int movetop;
                moveleft = (width - mBitmap.getWidth()) /2;
                movetop = (height - mBitmap.getHeight()) /2;
                shaderMatrix.postTranslate(moveleft, movetop);
                break;
        }

        bitmapShader.setLocalMatrix(shaderMatrix);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(mRect, cornerRadius, cornerRadius, paint);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        paint.setColorFilter(cf);
    }
}
