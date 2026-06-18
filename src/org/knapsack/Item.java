package org.knapsack;

public class Item {
    private int value;
    private int weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() { return value; }
    public int getWeight() { return weight; }

    public double getRatio() {
        return (double) value / weight;
    }

    @Override
    public String toString() {
        return "wartosc: " + value + " waga: " + weight;
    }
}