package com.mygdx.game.hmm.Units;

public class Robber extends InfantClass {

    public Robber(String name,int x, int y) {
        super(name, 8, 3, new int[] {2, 5}, 10, 6, x, y,10);
    }
    public String getType(){
        return "Robber";
    }

    public boolean isAlive(){
        if (health > 0) return true;
        else return false;
    }
}
