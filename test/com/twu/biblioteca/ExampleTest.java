package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {
    @Test
    public void initialMessageShouldBeWelcome() {
        assertEquals("Welcome!", BibliotecaApp.getWelcomeMessage());
    }
}
