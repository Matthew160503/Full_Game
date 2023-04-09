package com.mygdx.game.hmm.Units;

public class Magician extends BaseHero {

    private int mana;
    private int maxMana;

    public Magician(String name,int x, int y) {
        super(name, 17, 12, new int[] {2, 5}, 30, 9, x, y);
        this.maxMana = 1;
        this.mana = maxMana;
    }

    public int getMana(){
        return mana;
    }
    
    public String getType(){
        return "Magician";
    }

    public boolean isAlive(){
        if (health > 0) return true;
        else return false;
    }
}
