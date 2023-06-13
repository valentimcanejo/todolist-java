package com.example.myapplication;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class BotaoAdicionar extends View {
    private Paint circlePaint;
    private Paint plusPaint;

    public BotaoAdicionar(Context context) {
        super(context);
        init();
    }

    public BotaoAdicionar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BotaoAdicionar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        circlePaint = new Paint();
        circlePaint.setColor(Color.CYAN);
        circlePaint.setAntiAlias(true);

        plusPaint = new Paint();
        plusPaint.setColor(Color.WHITE);
        plusPaint.setStrokeWidth(10);
        plusPaint.setAntiAlias(true);
        plusPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2;

        canvas.drawCircle(width / 2, height / 2, radius, circlePaint);

        int tamanho = radius / 3;

        Path plusPath = new Path();
        plusPath.moveTo(width / 2, height / 2 - tamanho);
        plusPath.lineTo(width / 2, height / 2 + tamanho);
        plusPath.moveTo(width / 2 - tamanho, height / 2);
        plusPath.lineTo(width / 2 + tamanho, height / 2);

        canvas.drawPath(plusPath, plusPaint);
    }
}