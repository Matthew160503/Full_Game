package com.mygdx.game.hmm.Units;

import java.util.ArrayList;

public interface Interface {
    
    String getInfo();

    void step(ArrayList<BaseHero> otherTeam,ArrayList<BaseHero> ourTeam);
}
