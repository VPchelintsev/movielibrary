package org.example.handlers;

public enum MenuOptions
{
    DISPLAY_ALL_INFORMATION_ABOUT_RANDOM_MOVIE(1),
    DISPLAY_ALL_MOVIES_FOR_SELECTED_ACTOR(2),
    QUIT(3);

    int action;
    MenuOptions(int action){
        this.action = action;
    }
}
