package com.mygdx.game.hmm.Units;

import java.util.ArrayList;

public class Shooter extends BaseHero {
    protected int arrows;

    public Shooter(String name, int attack, int defence, int[] damage, int maxHealth, int speed, int arrows,int x,
            int y) {
        super(name, attack, defence, damage, maxHealth, speed, x, y);
        this.arrows = arrows;
    }

    @Override
    public void step(ArrayList<BaseHero> otherTeam, ArrayList<BaseHero> ourTeam) {
        if(this.arrows > 0 && this.health > 0){
            System.out.println("\n");
            System.out.printf("%s может стрелять. Стрелы: %d, Жизни: %f\n", this.getName(), this.arrows, this.health);

            BaseHero target = otherTeam.get(0);
            double minDistance = this.position.getDistance(otherTeam.get(0));

            for (BaseHero hero : otherTeam){
                if(minDistance > position.getDistance(hero) && hero.getHealth() > 0){
                    minDistance = position.getDistance(hero);
                    target = hero;
                }
            }

            attack(target, this.damage);
            this.arrows--;
            for(BaseHero hero : ourTeam){
                if (hero.toString().equals("Peasant")){
                    if(hero.getDelivery() > 0){
                        this.arrows++;
                        hero.checkDelivery();
                        System.out.printf("Стрелку добавлена патрона.Теперь всего патрон: %d\n",this.arrows);
                        break;
                    }
                    else{
                        System.out.println("Крестьянин больше не может доставлять партоны");
                        break;
                    }
                } 
            }
        }
        else System.out.println("Стрелок умер или не имеет стрел");
    }
}