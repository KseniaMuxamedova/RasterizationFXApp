package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Rasterization {

    public static void drawOval(
            final GraphicsContext graphicsContext,
            final int x0, final int y0,
            final int a, final int b,
            final Color startColor,
            final Color tailColor ){
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();
        float red = (float) ((startColor.getRed() - tailColor.getRed()) / 2 / b);
        float green = (float) (startColor.getGreen() - tailColor.getGreen()) / 2/ b;
        float blue = (float) (startColor.getBlue() - tailColor.getBlue()) /2 / b;
        int x1, x2, x;
        Color c = startColor;
        for(int i = y0 - b; i <= y0 + b; i++){
            x = (int) Math.sqrt(a * a * (1 - (float)(i - y0) * (float)(i - y0) / (float)b /(float)b));
            x1 = x0 - x;
            x2 = x0 + x;
            for (int j = x1; j <= x2; j++){
                pixelWriter.setColor(j, i , c);
            }
            if(c.getRed() + red < 1 && c.getGreen() + green < 1 && c.getBlue() + blue < 1){
                c = Color.color(c.getRed() + red, c.getGreen() + green, c.getBlue() + blue);
            }
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
