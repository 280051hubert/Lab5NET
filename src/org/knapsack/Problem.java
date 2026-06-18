package org.knapsack;

import java.util.*;

public class Problem {
    private int n;
    private int seed;
    private int lowerBound;
    private int upperBound;
    private List<Item> items;

    public Problem(int n, int seed, int lowerBound, int upperBound) {
        this.n = n;
        this.seed = seed;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.items = new ArrayList<>();

        Random random = new Random(seed);
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int weight = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            items.add(new Item(value, weight));
        }
    }

    public List<Item> getItems() { return items; }
    public int getN() { return n; }

    //algorytm dantzinga
    public Result solve(int capacity) {
        // lista indeksow posortowanych po wartosc:waga
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        Arrays.sort(indices, (a, b) ->
                Double.compare(items.get(b).getRatio(), items.get(a).getRatio()));

        Result result = new Result();
        int remainingCapacity = capacity;

        for (int idx : indices) {
            Item item = items.get(idx);
            if (item.getWeight() <= remainingCapacity) {
                int count = remainingCapacity / item.getWeight();//o tutaj
                result.addItem(idx, count, item.getValue(), item.getWeight());
                remainingCapacity -= count * item.getWeight();
            }
            if (remainingCapacity == 0) break;
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append("NR: ").append(i).append(" ").append(items.get(i)).append("\n");
        }
        return sb.toString();
    }
}