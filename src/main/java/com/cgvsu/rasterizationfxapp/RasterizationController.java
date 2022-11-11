package com.cgvsu.rasterizationfxapp;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.cgvsu.rasterization.*;
import javafx.scene.paint.Color;

public class RasterizationController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));
        Color c1 = Color.rgb(239, 9, 205);
        Color c2 = Color.rgb(64, 204, 1);
        Rasterization.drawOval(canvas.getGraphicsContext2D(), 400, 300, 300, 200, c1, c2);
        Color c3 = Color.rgb(0, 0, 0);
        Color c4 = Color.rgb(255, 255, 255);
        Rasterization.drawOval(canvas.getGraphicsContext2D(), 150, 220, 150, 220, c3, c4);
        /*Color c5 = Color.rgb(255, 255, 255);
        Color c6 = Color.rgb(0, 0, 0);
        Rasterization.drawOval(canvas.getGraphicsContext2D(), 200, 350, 100, 120, c5, c6);*/

    }

}