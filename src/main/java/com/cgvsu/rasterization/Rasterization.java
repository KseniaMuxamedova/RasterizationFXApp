package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Rasterization {

    public static void drawOval(
            final GraphicsContext graphicsContext,
            final int x0, final int y0,
            final int a, final int b,
            Color startColor,
            final Color tailColor) {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();
        //начальные оттенки
        int cRed = toRGB(startColor.getRed());
        int cGreen = toRGB(startColor.getGreen());
        int cBlue = toRGB(startColor.getBlue());
        //нахождение отрезков
        int red = findRaznost(cRed, toRGB(tailColor.getRed()), b);
        int green = findRaznost(cGreen, toRGB(tailColor.getGreen()), b);
        int blue = findRaznost(cBlue, toRGB(tailColor.getBlue()), b);
        //нахождение -1 или 1 операция с цветом
        int rk = findK(cRed, toRGB(tailColor.getRed()));
        int gk = findK(cGreen, toRGB(tailColor.getGreen()));
        int bk = findK(cBlue, toRGB(tailColor.getBlue()));
        int x1, x2, x;
        int z = 1;
        for (int i = y0 - b; i <= y0 + b; i++, z++) {
            x = (int) Math.sqrt(a * a * (1 - (float) (i - y0) * (float) (i - y0) / (float) b / (float) b));
            x1 = x0 - x;
            x2 = x0 + x;
            for (int j = x1; j <= x2; j++) {
                pixelWriter.setColor(j, i, startColor);
            }
            cRed = newC(z, cRed, red, rk);
            cGreen = newC(z, cGreen, green, gk);
            cBlue = newC(z, cBlue, blue, bk);
            startColor = Color.rgb(cRed, cGreen, cBlue);
        }
    }

    //перевод в RGB
    private static int toRGB(double c) {
        return (int) (c * 186);
    }

    //Изменение оттенка
    private static int newC(int i, int st, int d, int k){
        if(i % d == 0 && st + k > 0 && st + k < 255){
            st += k;
        }
        return st;
    }

    //Отрезки
    private static int findRaznost(int start, int tail, int b){
        if(start == tail){
            return 2*b;
        }
        return Math.round(Math.abs((2 * b) / (start - tail)));
    }

    //-1 или 1
    private static int findK(int start, int tail){
        if(start > tail){
            return -1;
        }else {
            return 1;
        }
    }
}

/* Реализовать метод (класс) для заполнения эллипса. Добавить возможность
интерполяции цвета, например, при удалении от центра фигуры. На вход могут
поступать координаты левого верхнего угла вместе с шириной и высотой фигуры.
10
Или центр эллипса и размеры полуосей a и b. Возможны и другие варианты. [2],
[3]
*/
