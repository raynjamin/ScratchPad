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
