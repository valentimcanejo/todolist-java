package com.example.myapplication;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class BotaoAdicionar extends View {
    private Paint circulo;
    private Paint sinalAdicionar;

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
        circulo = new Paint();
        circulo.setColor(Color.CYAN);

        sinalAdicionar = new Paint();
        sinalAdicionar.setColor(Color.WHITE);
        sinalAdicionar.setStrokeWidth(10);
        sinalAdicionar.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int largura = getWidth();
        int altura = getHeight();
        int radius = Math.min(largura, altura) / 2;

        canvas.drawCircle(largura / 2, altura / 2, radius, circulo);

        int tamanho = radius / 3;

        Path sinal = new Path();
        sinal.moveTo(largura / 2, altura / 2 - tamanho);
        sinal.lineTo(largura / 2, altura / 2 + tamanho);
        sinal.moveTo(largura / 2 - tamanho, altura / 2);
        sinal.lineTo(largura / 2 + tamanho, altura / 2);

        canvas.drawPath(sinal, sinalAdicionar);
    }
}