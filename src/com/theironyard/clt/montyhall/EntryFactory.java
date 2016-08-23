package com.theironyard.clt.montyhall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 6/16/16.
 */
public class EntryFactory {
    public static List<Entry> getRandomEntries() {
        List<Entry> results = new ArrayList<>();

        results.add(new Goat());
        results.add(new Goat());

        results.add((int)(Math.random() * 3), new Car());

        return results;
    }
}
