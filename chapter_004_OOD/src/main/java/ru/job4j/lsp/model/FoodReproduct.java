package ru.job4j.lsp.model;

public class FoodReproduct {
    private final Food food;
    private boolean canReproduct;


    public FoodReproduct(Food food, boolean canReproduct) {
        this.canReproduct = canReproduct;
        this.food = food;
    }

    public Food getFood() {
        return food;
    }

    public boolean isCanReproduct() {
        return canReproduct;
    }

    public void setCanReproduct(boolean canReproduct) {
        this.canReproduct = canReproduct;
    }
}
