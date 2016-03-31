package com.theironyard.clt;

/**
 * Created by Ben on 3/31/16.
 */
public class Player {
    private String name;
    private String weapon;
    private String location;

    Player(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return this.weapon;
    }

    public void setWeapon(String weaponName) {
        this.weapon = weaponName;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
