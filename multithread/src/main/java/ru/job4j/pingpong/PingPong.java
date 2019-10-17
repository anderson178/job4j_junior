package ru.job4j.pingpong;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class PingPong extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        int limitX = 100;
        int limitY = 100;
        Group group = new Group();
        Rectangle rect = new Rectangle(10, 50, 10, 10);
        group.getChildren().add(rect);
        new Thread(new RectangleMove(rect, limitX, limitY)).start();
        stage.setScene(new Scene(group, limitX, limitY));
        stage.setResizable(false);
        stage.show();
    }
}
