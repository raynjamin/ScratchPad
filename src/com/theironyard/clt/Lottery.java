package com.theironyard.clt;

import java.util.*;

/**
 * Created by Ben on 5/12/16.
 */
public class Lottery {
    HashMap<String, Integer> guesses = new HashMap<>();
    HashMap<String, Integer> winners = new HashMap<>();

    public void guess(String name, int guess) {
        if (guess > 0 && guess <= 100) {
            guesses.put(name, guess);
        } else {
            System.err.println("Guesses need to be between 1 and 100 inclusive.");
        }
    }

    public void pick() {
        Integer number = (int)(Math.ceil(Math.random()*100));

        guesses.forEach((key, value) -> {
            if (!Objects.equals(value, number)) return;
            winners.put(key, value);
        });
    }

    public HashMap<String, Integer> getWinners() {
        return this.winners;
    }

}
