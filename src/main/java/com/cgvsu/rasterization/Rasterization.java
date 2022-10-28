package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Rasterization {

    public static void drawOval(
            final GraphicsContext graphicsContext,
            final int x0, final int y0,
            final int a, final int b,
            final Color color){
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        int x1, x2;
        for(int i = y0 - b; i <= y0 + b; i++){
            x1 = x0 - (int) Math.sqrt(a * a * (1 - (float)(i - y0) * (float)(i - y0) / (float)b /(float)b));
            x2 = x0 + (int) Math.sqrt(a * a * (1 - (float)(i - y0) * (float)(i - y0) / (float)b /(float)b));

//            System.out.println( (1 - (float)(i - y0) * (i - y0) / b /b));

            for (int j = x1; j <= x2; j++){
                pixelWriter.setColor(j, i , color);
            }
        }

    }

    public static void drawRectangle(
            final GraphicsContext graphicsContext,
            final int x, final int y,
            final int width, final int height,
            final Color color)
    {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        for (int row = y; row < y + height; ++row)
            for (int col = x; col < x + width; ++col)
                pixelWriter.setColor(col, row, color);
    }
}
