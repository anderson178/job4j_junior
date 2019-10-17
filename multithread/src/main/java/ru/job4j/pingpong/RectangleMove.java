package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private final int limitX;
    private final int limitY;
    private boolean travelRight = true;
    private boolean travelLeft = true;

    public RectangleMove(Rectangle rect, int limitX, int limitY) {
        this.rect = rect;
        this.limitX = limitX;
        this.limitY = limitY;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {


            if (travelRight) {
                this.rect.setX(this.rect.getX() + 1);
                if (rect.getX() == limitX - rect.getWidth()) {
                    travelRight = false;
                }
            } else {
                this.rect.setX(this.rect.getX() - 1);
                if (rect.getX() == rect.getWidth()) {
                    travelRight = true;
                }
            }

            if (travelLeft) {
                this.rect.setY(this.rect.getY() + 1);
                if (rect.getY() == limitY - rect.getHeight()) {
                    travelLeft = false;
                }
            } else {
                this.rect.setY(this.rect.getY() - 1);
                if (rect.getY() == rect.getHeight()) {
                    travelLeft = true;
                }
            }


            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
