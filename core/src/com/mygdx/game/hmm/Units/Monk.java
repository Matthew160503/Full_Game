package com.mygdx.game.hmm.Units;

public class Monk extends BaseHero {

    private int elixir;
    private int maxElixir;

    public Monk(String name,int x, int y) {
        super(name, 12, 7, new int[] {1,4}, 30, 5, x, y);
        this.maxElixir = 1;
        this.elixir = maxElixir;
    }

    public int getElixir(){
        return elixir;
    }

    public String getType(){
        return "Monk";
    }

    public boolean isAlive(){
        if (health > 0) return true;
        else return false;
    }
}
