package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class ItemsArchive {
    private List<Item> items;

    public ItemsArchive(List<Item> items){
        this.items = items;
    }

    public ItemsArchive() {
        load();
    }

    private void load(){
        Item bible = new Item("1984", "George Orwell", 1949);
        Item americanGods = new Item("American Gods", "Neil Gaiman", 2001);
        Item foundation = new Item("Foundation", "Isaac Asimov", 1951);
        Item harryPotter1 = new Item("Harry Potter and the Philosophers Stone", "J. K. Rowling", 1997);
        Item hobbit = new Item("The Hobbit", ". R. R. Tolkien", 1937);
        Item hungerGames = new Item("The Hunger Games", "Suzanne Collins", 2008);

        Movie titanic = new Movie("Titanic", "James Cameron", 1997, 7.7);
        Movie avatar = new Movie("Avatar", "James Cameron", 2009, 7.8);
        Movie moonlight = new Movie("Moonlight", "Barry Jenkins", 2017, 7.8);
        Movie laland = new Movie("La La Land", "Damien Chazelle", 2017, 8.5);
        Movie lion = new Movie("Lion", "Garth Davis", 2017, 8);

        List<Item> items = new ArrayList<>();
        items.add(bible);
        items.add(americanGods);
        items.add(foundation);
        items.add(harryPotter1);
        items.add(hobbit);
        items.add(hungerGames);

        items.add(titanic);
        items.add(avatar);
        items.add(moonlight);
        items.add(laland);
        items.add(lion);

        this.items = items;
    }

    private String listItems(String header, boolean shouldListOnlyBooks){
        String listOfItems = header;

        for (Item item: items) {
            if(shouldListThisItem(item, shouldListOnlyBooks)){
                listOfItems = String.join("\n", listOfItems, item.toString());
            }
        }
        return listOfItems;
    }

    private boolean shouldListThisItem(Item item, boolean shouldListOnlyBooks){
        boolean listItem = false;

        if(!item.isCheckedOut()) {
            boolean isMovie = isMovieInstance(item);

            if ((!shouldListOnlyBooks && isMovie) || (shouldListOnlyBooks && !isMovie)) {
                listItem = true;
            }
        }
        return listItem;
    }

    protected String listBooks() {
        return listItems("Title | Author | Year", true);
    }

    protected String listMovies(){
        return listItems("Title | Director | Year | Rating", false);
    }

    private boolean containsItem(Item item){
        return items.contains(item);
    }

    private Item getItem(Item item) throws IndexOutOfBoundsException {
        return items.get(items.indexOf(item));
    }

    protected String checkoutMovie(String itemTitle) {
        Movie movie = new Movie(itemTitle, null, 0, 0);
        return checkoutItem(movie);
    }

    protected String checkoutItem(String itemTitle) {
        Item book = new Item(itemTitle, null, 0);
        return checkoutItem(book);
    }

    private String checkoutItem(Item item) {
        String checkoutMessage = "That item is not available";
        if(containsItem(item)) {
            Item itemInArchive;
            try {
                itemInArchive = getItem(item);
            } catch (IndexOutOfBoundsException e) {
                return checkoutMessage;
            }
            if (!itemInArchive.isCheckedOut()) {
                itemInArchive.checkOut();
                checkoutMessage = "Thank you! Enjoy the item";
            }
        }
        return checkoutMessage;
    }

    protected String returnItem(String itemTitle){
        Item item = new Item(itemTitle, null, 0);
        String returnItemMessage = "That is not a valid item to return.";
        try {
            Item itemInArchive = getItem(item);
            if (itemInArchive.isCheckedOut()) {
                itemInArchive.returnItem();
                returnItemMessage = "Thank you for returning the item.";
            }
        } catch (IndexOutOfBoundsException e) {
            return returnItemMessage;
        }
        return returnItemMessage;
    }

    private boolean isMovieInstance(Item item){
        boolean isInstance = false;
        if(item instanceof Movie){
            isInstance = true;
        }
        return isInstance;
    }

}