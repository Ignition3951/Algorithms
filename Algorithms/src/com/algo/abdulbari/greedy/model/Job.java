package com.algo.abdulbari.greedy.model;

public class Job {

    private int profit;
    private int deadline;
    private String name;

    public Job(String name, int profit, int deadline) {
        this.name = name;
        this.profit = profit;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public int getProfit() {
        return profit;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", profit=" + profit +
                ", deadline=" + deadline +
                '}';
    }
}
