package com.theironyard.game;

import java.io.PrintStream;
import java.util.Scanner;


/**
 * Created by Ben on 3/31/16.
 */
public class Game {
    public Player[] players = new Player[3]; // [null, null, null]
    private static Scanner input = new Scanner(System.in);
    private static PrintStream output = System.out;

    public Game() {
        greetPlayer();
        buildPlayers();
    }

    public void start() {
        // for player one (players[0])
        // ask for a weapon and assign it to player[0]'s weapon
        // ask for a location and assign it to player [0]'s location
        // ask how many enemies player[0] has slain and assign it to player

        // print out all this information
    }

    private static void greetPlayer() {
        output.println("Hi from Text Adventure!!!");
    }

    private void buildPlayers() {

        for(int i = 0;i < players.length;i++) {
            output.println("What is player " + (i + 1) + "'s name?");
            String name = input.nextLine();
            players[i] = new Player(name);
        }
    }
}
