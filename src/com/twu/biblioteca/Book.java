package com.twu.biblioteca;

/**
 * Created by gcampos on 07/03/17.
 */
public class Book extends Item {
    public Book(String title, String author, int year) {
        super(title, author, year);
    }

    @Override
    public boolean equals(Object item2){
        if(this == item2){
            return true;
        }

        if(!(item2 instanceof Movie)){
            return false;
        }

        return this.getTitle().equalsIgnoreCase(((Book) item2).getTitle());
    }

    public String toString(){
        return String.format("%s | %s | %d", this.getTitle(), this.getAuthor(), this.getYear());
    }
}
