package org.knapsack;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<Integer> itemIndices;
    private List<Integer> itemCounts;
    private int totalValue;
    private int totalWeight;

    public Result() {
        this.itemIndices = new ArrayList<>();
        this.itemCounts = new ArrayList<>();
        this.totalValue = 0;
        this.totalWeight = 0;
    }

    public void addItem(int index, int count, int value, int weight) {
        this.itemIndices.add(index);
        this.itemCounts.add(count);
        this.totalValue += value * count;
        this.totalWeight += weight * count;
    }

    public List<Integer> getItemIndices() { return itemIndices; }
    public List<Integer> getItemCounts() { return itemCounts; }
    public int getTotalValue() { return totalValue; }
    public int getTotalWeight() { return totalWeight; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("============");
        sb.append("\n");
        for (int i = 0; i < itemIndices.size(); i++) {
            int idx = itemIndices.get(i);
            int count = itemCounts.get(i);
            for (int j = 0; j < count; j++) {
                sb.append("NR: ").append(idx).append("\n");
            }
        }
        sb.append("WAGA: ").append(totalWeight).append("\n");
        sb.append("WARTOSC: ").append(totalValue);
        return sb.toString();
    }
}