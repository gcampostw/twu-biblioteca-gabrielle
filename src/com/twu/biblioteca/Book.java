package com.twu.biblioteca;

public class Book extends Item {
    public Book(String title, String author, int year) {
        super(title, author, year);
    }

    @Override
    public boolean equals(Object item2){
        if(this == item2){
            return true;
        }

        if(!(item2 instanceof Book)){
            return false;
        }

        return this.getTitle().equalsIgnoreCase(((Book) item2).getTitle());
    }

    @Override
    public String toString(){
        return String.format("%s | %s | %d", this.getTitle(), this.getAuthor(), this.getYear());
    }
}
