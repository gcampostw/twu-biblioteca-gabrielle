package com.twu.biblioteca;

public class Movie extends Book {
    private int rating;

    public Movie(String title, String author, int year, int rating) {
        super(title, author, year);
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString(){
        return String.format("%s | %s | %d | %d", this.getTitle(), this.getAuthor(), this.getYear(), this.rating);
    }
}