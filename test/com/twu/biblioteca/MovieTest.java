package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gcampos on 07/03/17.
 */
public class MovieTest {

    @Test
    public void shouldBeEqualWhenComparingToItself(){
        Movie movie = new Movie("Titanic", null, 0,0);
        assertTrue(movie.equals(movie));
    }

    @Test
    public void shouldNotBeEqualToAObjectThatIsNotAMovie(){
        Item item = new Item("Titanic", null, 0);
        Movie movie = new Movie("Titanic", null, 0,0);
        assertFalse(movie.equals(item));
    }

    @Test
    public void shouldBeEqualToMovieWithSameTitle(){
        Movie movie = new Movie("Titanic", null, 0,0);
        Movie movie2 = new Movie("Titanic", null, 0,0);
        assertTrue(movie.equals(movie2));
    }

}