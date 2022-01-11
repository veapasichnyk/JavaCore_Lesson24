package ua.lviv.lgs.task1;

public class Human {
    private int weight;
    private int height;

    public Human (int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public Human( ){
    }

    public double getHeight ( ) {
        return height;
    }

    public double getWeight ( ) {
        return weight;
    }

    @Override
    public String toString ( ) {
        return "Human{" +
               "weight=" + weight +
               ", height=" + height +
               '}';
    }
}
