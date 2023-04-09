package com.mygdx.game.hmm.Units;

public class Spearman extends InfantClass{

    public Spearman(String name,int x, int y) {
        super(name, 4, 5, new int[] {1, 3}, 10, 4, x, y,10);
    }

    public String getType(){
        return "Spearman";
    }

    public boolean isAlive(){
        if (health > 0) return true;
        else return false;
    }
}