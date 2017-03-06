package com.twu.biblioteca;

public class Item {
    private String title;
    private int year;
    private String author;
    private boolean checkedOut;

    public Item(String title, String author, int year){
        this.title = title;
        this.year = year;
        this.author = author;
        this.checkedOut = false;
    }

    public void checkOut() {
        this.checkedOut = true;
    }

    public void returnItem(){
        this.checkedOut = false;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object item2){
        return this.getTitle().equalsIgnoreCase(((Item) item2).getTitle());
    }

    public String toString(){
        return String.format("%s | %s | %d", this.getTitle(), this.getAuthor(), this.getYear());
    }
}