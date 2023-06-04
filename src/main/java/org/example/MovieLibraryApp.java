package org.example;

import org.example.handlers.MenuHandlers;
import org.example.handlers.UserInputHandlers;
import org.example.models.MovieLibrary;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MovieLibraryApp {
    public static void main(String[] args) {
        //Load Film Library
        MovieLibrary movieLibrary = new MovieLibrary();
        movieLibrary.fillMovieList();
        while (true) {
            MenuHandlers.print();

            switch (UserInputHandlers.getMenuOptionFromUser()) {
                case DISPLAY_ALL_INFORMATION_ABOUT_RANDOM_MOVIE:
                    movieLibrary.getRandomMovieInformation();
                    break;
                case DISPLAY_ALL_MOVIES_FOR_SELECTED_ACTOR:
                    movieLibrary.printActorFilmography();
                    break;
                case QUIT:
                    System.out.println("\nGood bye");
                    System.exit(1);

            }
        }
    }


}


