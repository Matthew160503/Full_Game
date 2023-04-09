package com.mygdx.game.hmm.Units;

import java.util.ArrayList;

public class InfantClass extends BaseHero {
    
    int stamina;

    public InfantClass(String name, int attack, int defence, int[] damage, int maxHealth, int speed, int x,
            int y, int stamina) {
        super(name, attack, defence, damage, maxHealth, speed, x, y);
        this.stamina = stamina;
    }

    @Override
    public void step(ArrayList<BaseHero> otherTeam, ArrayList<BaseHero> ourTeam) {
        if(this.stamina > 0 && this.health > 0){

            BaseHero target = otherTeam.get(0);
            double minDistance = this.position.getDistance(otherTeam.get(0));

            for (BaseHero hero : otherTeam){
                if(minDistance > position.getDistance(hero) && hero.getHealth() > 0){
                    minDistance = position.getDistance(hero);
                    target = hero;
                }
            }
            boolean[] temp = position.checkPos(ourTeam);
            if(minDistance > 2) this.position.direction(target.position, temp);
            else if(target.health > 0){
                attack(target, this.damage);
                this.stamina--;
            }
        }
    }
}
