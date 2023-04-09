package com.mygdx.game.hmm.Units;

public class Sniper extends Shooter{

    public Sniper(String name,int x, int y) {
        super(name, 12, 10, new int[] {1, 3}, 15, 9, 32, x, y);
    }
    
    public String getType(){
        return "Sniper";
    }

    public boolean isAlive(){
        if (health > 0) return true;
        else return false;
    }
}