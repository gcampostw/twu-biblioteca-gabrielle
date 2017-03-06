package com.twu.biblioteca;

public class Movie extends Item {
    private double rating;

    public Movie(String title, String author, int year, double rating) {
        super(title, author, year);
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString(){
        return String.format("%s | %s | %d | %.1f", this.getTitle(), this.getAuthor(), this.getYear(), this.getRating());
    }
}