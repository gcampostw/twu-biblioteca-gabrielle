package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class ItensArchive {
    private List<Book> itens;

    public ItensArchive(List<Book> itens){
        if(itens == null){
            load();
        }else{
            this.itens = itens;
        }
    }

    public void load(){
        Book bible = new Book("1984", "George Orwell", 1949);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        Book foundation = new Book("Foundation", "Isaac Asimov", 1951);
        Book harryPotter1 = new Book("Harry Potter and the Philosophers Stone", "J. K. Rowling", 1997);
        Book hobbit = new Book("The Hobbit", ". R. R. Tolkien", 1937);
        Book hungerGames = new Book("The Hunger Games", "Suzanne Collins", 2008);

        Movie titanic = new Movie("Titanic", "James Cameron", 1997, 7.7);
        Movie avatar = new Movie("Avatar", "James Cameron", 2009, 7.8);
        Movie moonlight = new Movie("Moonlight", "Barry Jenkins", 2017, 7.8);
        Movie laland = new Movie("La La Land", "Damien Chazelle", 2017, 8.5);
        Movie lion = new Movie("Lion", "Garth Davis", 2017, 8);

        List<Book> itens = new ArrayList<>();
        itens.add(bible);
        itens.add(americanGods);
        itens.add(foundation);
        itens.add(harryPotter1);
        itens.add(hobbit);
        itens.add(hungerGames);

        itens.add(titanic);
        itens.add(avatar);
        itens.add(moonlight);
        itens.add(laland);
        itens.add(lion);

        this.itens = itens;
    }

    public String listTitles(){
        String listOfBooks = "| Title | ";
        for (Book book: itens) {
            listOfBooks = String.join("\n", listOfBooks, book.getTitle());
        }
        return listOfBooks;
    }

    private String listItens(String header){
        String listOfItems = header;
        boolean listBooks = true;
        if(header.contains("Rating")){
            listBooks = false;
        }
        for (Book item: itens) {
            if(!item.isCheckedOut()){
                if((!listBooks && item instanceof Movie) || (listBooks && !(item instanceof Movie))){
                    listOfItems = String.join("\n", listOfItems, item.toString());
                }
            }
        }
        return listOfItems;
    }

    public String listBooks() {
        return listItens("Title | Author | Year");
    }

    public String listMovies(){
        return listItens("Title | Director | Year | Rating");
    }

    public boolean containsItem(Book item){
        return itens.contains(item);

    }

    public Book getItem(Book item) throws IndexOutOfBoundsException {
        return itens.get(itens.indexOf(item));

    }

    public String checkoutItem(String itemTitle) {
        Book item = new Book(itemTitle, null, 0);
        String checkoutMessage = "That book is not available";
        if(containsItem(item)) {
            Book itemInArchive;
            try {
                itemInArchive = getItem(item);
            } catch (IndexOutOfBoundsException e) {
                return checkoutMessage;
            }
            if (!itemInArchive.isCheckedOut()) {
                itemInArchive.checkOut();
                checkoutMessage = "Thank you! Enjoy the book";
            }
        }
        return checkoutMessage;
    }

    public String returnItem(String itemTitle){
        Book item = new Book(itemTitle, null, 0);
        String returnItemMessage = "That is not a valid book to return.";
        try {
            Book itemInArchive = getItem(item);
            if (itemInArchive.isCheckedOut()) {
                itemInArchive.returnItem();
                returnItemMessage = "Thank you for returning the book.";
            }
        } catch (IndexOutOfBoundsException e) {
            return returnItemMessage;
        }
        return returnItemMessage;
    }

}