package org.example.models;

import org.example.handlers.RandomDataHandler;
import org.example.handlers.UserInputHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieLibrary {
    private static List<Movie> moviesLibrary;

    public void fillMovieList() {
        moviesLibrary = new ArrayList<>();

        Director r_Scott = new Director("Ridley", "Scott");
        Director g_Verbinski = new Director("Gore", "Verbinski");
        Director q_Tarantino = new Director("Quentin", "Tarantino");
        Director p_Jackson = new Director("Peter", "Jackson");
        Actor r_Crowe = new Actor("Russel", "Crowe");
        Actor o_Reed = new Actor("Oliver", "Reed");
        Actor d_Jacob = new Actor("Dari", "Jacob");
        Actor j_Deep = new Actor("Johnny", "Deep");
        Actor o_Bloom = new Actor("Orlando", "Bloom");
        Actor k_Knightley = new Actor("Keira", "Knightley");
        Actor j_Travolta = new Actor("John", "Travolta");
        Actor u_Thurman = new Actor("Uma", "Thurman");
        Actor h_Keitel = new Actor("Harvey", "Keitel");
        Actor t_Cruze = new Actor("Tom", "Cruise");

        moviesLibrary.add(new Movie("Gladiator", r_Scott, List.of(r_Crowe, j_Deep)));
        moviesLibrary.add(new Movie("Pirates of the Caribbean", g_Verbinski, List.of(o_Reed, j_Deep)));
        moviesLibrary.add(new Movie("Pulp Fiction", q_Tarantino, List.of(j_Travolta, u_Thurman)));
        moviesLibrary.add(new Movie("Hobbit - An Unexpected Jorney", r_Scott, List.of(k_Knightley, d_Jacob)));
        moviesLibrary.add(new Movie("Poranek Kojota", p_Jackson, List.of(r_Crowe, o_Bloom)));
        moviesLibrary.add(new Movie("Transformers", q_Tarantino, List.of(r_Crowe, d_Jacob)));
        moviesLibrary.add(new Movie("Top Gun", r_Scott, List.of(r_Crowe, t_Cruze)));
        moviesLibrary.add(new Movie("Desperado", r_Scott, List.of(r_Crowe, o_Bloom)));
        moviesLibrary.add(new Movie("Mission Impossible", p_Jackson, List.of(r_Crowe, t_Cruze)));
        moviesLibrary.add(new Movie("Forest Gump", g_Verbinski, List.of(o_Reed, h_Keitel)));
    }

    public static List<Movie> getMoviesLibrary() {
        return moviesLibrary;
    }

    public void getRandomMovieInformation() {
        System.out.println(moviesLibrary.get(RandomDataHandler.getRandomMovieIndex()));
    }

    public void printActorFilmography() {
        Actor actor = UserInputHandlers.getActorFromUSer();
        var actorMovieList = getActorMovieList(actor);
        if (actorMovieList.isEmpty()) {
            System.out.println("Actor didnt play in any movie from the library");
        } else {
            System.out.println("Actor " + actor + " have played on following movies: ");
            for (String movie : actorMovieList) {
                System.out.println(movie);
            }
        }
    }

    private List <String> getActorMovieList(Actor actorToFind) {
        Predicate <Movie> moviePredicate = movie -> movie.getListOfActors().stream()
                .anyMatch(actor -> actor.getFirstName().equals(actorToFind.getFirstName()) &&
                        actor.getLastName().equals(actorToFind.getLastName()));
        return moviesLibrary.stream()
                .filter(moviePredicate)
                .map(Movie::getTitle)
                .collect(Collectors.toList());
    }
}

