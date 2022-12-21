package com.example.competitiveexamtrainer;

public class MarkModel {
    int rank;
    String name;
    Integer mark;

    public MarkModel(int rank, String name, Integer mark) {
        this.rank = rank;
        this.name = name;
        this.mark = mark;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public Integer getMark() {
        return mark;
    }
}
