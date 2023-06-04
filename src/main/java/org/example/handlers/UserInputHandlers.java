package org.example.handlers;

import org.example.models.Actor;

import java.util.Scanner;

public class UserInputHandlers
{
   private static Scanner scanner = new Scanner(System.in);
    public static MenuOptions getMenuOptionFromUser()
    {
        return MenuOptions.values()[getSelectedOptionFromUser()-1];
    }

    private static int getSelectedOptionFromUser() {
      var result = getIntegerFromUser();
       scanner.nextLine();
      if(result>0 && result<MenuOptions.values().length+1){
          return result;
      }
      else
      {
          System.out.println("You selected no existing option " + result);
          System.out.println("Please try again");
          return  getSelectedOptionFromUser();
      }
    }

    private static int getIntegerFromUser() {
        while (!scanner.hasNext()){
            scanner.nextLine();
            System.out.println("It is not integer. Please try again");
        }
        return scanner.nextInt();
    }
    public static Actor getActorFromUSer(){
        System.out.println("Type an actor name");
        var s = scanner.nextLine().split(" ");

        return new Actor(s[0],s[1]);
    }
}
