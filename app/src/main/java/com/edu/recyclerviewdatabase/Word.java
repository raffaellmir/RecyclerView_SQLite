package com.edu.recyclerviewdatabase;

public class Word {
    private Integer id;
    private final String text;
    private final Integer color;
    private final Boolean isFav;
    private final Boolean isBought;

    public  Word(Integer id, String text, Integer color, Boolean isFav, Boolean isBought) {
        this.text = text;
        this.color = color;
        this.isFav = isFav;
        this.isBought = isBought;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Integer getColor() {
        return color;
    }

    public Boolean getFav() {
        return isFav;
    }

    public Boolean getBought() {
        return isBought;
    }
}
