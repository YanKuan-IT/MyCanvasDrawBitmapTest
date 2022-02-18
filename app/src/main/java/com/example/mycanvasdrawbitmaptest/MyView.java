package com.example.mycanvasdrawbitmaptest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint mPaint = new Paint();

        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);

        int mBitmapWidth = mBitmap.getWidth();   // 图片的宽 640
        int mBitmapHeight = mBitmap.getHeight(); // 图片的高 360

        // 方法1 演示
        canvas.drawBitmap(mBitmap, 0f, 0f, mPaint);

        canvas.drawBitmap(mBitmap, 100f, 400f, mPaint); // 位移


        // 方法2 演示
        Rect dstRect = new Rect(0, 800, mBitmapWidth, 800 + mBitmapHeight);
        canvas.drawBitmap(mBitmap, null, dstRect, mPaint); // srcRect 为 null

        Rect srcRect = new Rect(0, 0, mBitmapWidth / 2, mBitmapHeight / 2);
        dstRect = new Rect(50, 1200, 50 + mBitmapWidth, 1200 + mBitmapHeight);
        canvas.drawBitmap(mBitmap, srcRect, dstRect, mPaint); // 裁剪左上角 1/4 的区域，并放大、右移
    }
}
