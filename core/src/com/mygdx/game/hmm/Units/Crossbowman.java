package com.mygdx.game.hmm.Units;


public class Crossbowman extends Shooter {

    public Crossbowman(String name,int x, int y) {
        super(name, 6, 3, new int[] {1, 2}, 10, 4, 16, x, y);
    }

    public String getType(){
        return "Crossbowman";
    }

    public boolean isAlive(){
        if (health > 0) return true;
        else return false;
    }
}
