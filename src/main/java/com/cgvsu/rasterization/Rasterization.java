package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Rasterization {

    public static void drawOval(
            final GraphicsContext graphicsContext,
            final int x0, final int y0,
            final int a, final int b,
            int startRED, int startGREEN, int startBLUE,
            int endRED, int endGREEN, int endBLUE
            //final Color startColor,
            /*final Color tailColor*/) {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();
        Color c = Color.rgb(startRED, startGREEN, startBLUE);
        //int cRed = toRGB(startColor.getRed());
        //int cGreen = toRGB(startColor.getGreen());
        //int cBlue = toRGB(startColor.getBlue());
        //int red = findRaznost(cRed, toRGB(tailColor.getRed()), b);
        //int green = findRaznost(cGreen, toRGB(tailColor.getGreen()), b);
        //int blue = findRaznost(cBlue, toRGB(tailColor.getBlue()), b);
        int redK = findRaznost(startRED, endRED, b);
        int rk = findK(startRED, endRED);
        int greenK = findRaznost(startGREEN, endGREEN, b);
        int gk = findK(startGREEN, endGREEN);
        int blueK = findRaznost(startBLUE, endBLUE, b);
        int bk = findK(startBLUE, endBLUE);
        int x1, x2, x;
        int rd = 0, gd = 0, bd = 0;
        for (int i = y0 - b; i <= y0 + b; i++, rd++, gd++, bd++) {
            x = (int) Math.sqrt(a * a * (1 - (float) (i - y0) * (float) (i - y0) / (float) b / (float) b));
            x1 = x0 - x;
            x2 = x0 + x;
            for (int j = x1; j <= x2; j++) {
                pixelWriter.setColor(j, i, c);
            }
            startRED = newC(startRED, redK, rd, rk);
            startGREEN = newC(startGREEN, greenK, gd, gk);
            startBLUE = newC(startBLUE, blueK, bd, bk );
            System.out.println(startBLUE);
            c = Color.rgb(startRED, startGREEN, startBLUE);
            rd =kofe(rd, redK);
            gd = kofe(gd, greenK);
            bd = kofe(bd, blueK);
        }
    }

    private static int toRGB(double c) {
        return (int) (c * 255);
    }

    private static int newC(int c, int a, int d, int k){
        if(d == a){
            c += k;
        }
        return c;
    }

    private static int kofe(int c, int a){
        if(c == a){
            c = 0;
        }
        return c;
    }

    private static int findRaznost(int start, int tail, int b){
        if(start == tail){
            return 2*b;
        }
        return Math.round((float)(2 * b) / Math.abs(start - tail));
    }

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
