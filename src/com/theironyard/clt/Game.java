package com.theironyard.clt;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Ben on 3/31/16.
 */
public class Game {
    Player player;
    private static Scanner input = new Scanner(System.in);
    private static PrintStream output = System.out;

    Game() {
        greetPlayer();
        buildPlayer();
    }

    private static void greetPlayer() {
        output.println("Hi from Text Adventure!!!");
    }

    private void buildPlayer() {
        output.println("What is your name?");

        String name = input.nextLine();

        player = new Player(name);
    }
}
