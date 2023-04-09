package com.mygdx.game.hmm;

import com.mygdx.game.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import com.mygdx.game.hmm.Units.*;

public class Init{
    public static void createTeams(){
        MyGdxGame.whiteSide = new ArrayList<>();
        MyGdxGame.darkSide = new ArrayList<>();
        MyGdxGame.fullStack = new ArrayList<>();

        int x = 1;
        int y = 1;
        for (int i = 0; i < MyGdxGame.GANG_SIZE; i++) {
            switch(new Random().nextInt(4)){
                case 0: MyGdxGame.whiteSide.add(new Peasant("Peasant", x, y++))
                ; break;
                case 1: MyGdxGame.whiteSide.add(new Crossbowman("Crossbowman", x, y++)); break;
                case 2: MyGdxGame.whiteSide.add(new Monk("Monk", x, y++)); break;
                default: MyGdxGame.whiteSide.add(new Spearman("Spearman", x, y++)); break;
            }
        }

        x = MyGdxGame.GANG_SIZE;
        y = 1;

        for (int i = 0; i < MyGdxGame.GANG_SIZE; i++) {
            switch(new Random().nextInt(4)){
                case 0: MyGdxGame.darkSide.add(new Peasant("Peasant", x, y++)); break;
                case 1: MyGdxGame.darkSide.add(new Sniper("Sniper", x, y++)); break;
                case 2: MyGdxGame.darkSide.add(new Magician("Magician", x, y++)); break;
                default: MyGdxGame.darkSide.add(new Robber("Robber", x, y++)); break;
            }
        }

        MyGdxGame.fullStack.addAll(MyGdxGame.whiteSide);
        MyGdxGame.fullStack.addAll(MyGdxGame.darkSide);
    }

    public static void makeStep(){
        MyGdxGame.fullStack.sort(new Comparator<BaseHero>(){
            @Override
            public int compare(BaseHero h1, BaseHero h2){
                if (h1.getSpeed() == h2.getSpeed()) return 0;
                else if (h1.getSpeed() > h2.getSpeed()) return 1;
                else return -1;
            }
        });

        for(BaseHero hero : MyGdxGame.fullStack){
            if(MyGdxGame.whiteSide.contains(hero)) hero.step(MyGdxGame.darkSide, MyGdxGame.whiteSide);
            else hero.step(MyGdxGame.whiteSide, MyGdxGame.darkSide);
        }
    }
}
