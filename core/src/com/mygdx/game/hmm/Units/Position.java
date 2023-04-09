package com.mygdx.game.hmm.Units;

import java.util.ArrayList;

public class Position {
    protected int x,y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEquals(Position opposit){
        if(opposit.y == y && opposit.x == x) return true;
        return false;
    }

    public float getDistance(BaseHero target){
        float dx = x- target.position.x;
        float dy = y - target.position.y;
        return (float)Math.sqrt(dx * dx + dy * dy);
    }

    public void direction(Position position,boolean[] temp){
        int dx = Math.abs(this.x-position.x);
        int dy = Math.abs(this.y-position.y);
        if (dx > dy){
            if(this.x < position.x){
                if(temp[0]) System.out.println("\nПуть прегражден\n");
                else this.x += 1;
            }
            else{
                if(temp[1]) System.out.println("\nПуть прегражден\n");
                else this.x -= 1;
            }
        }
        else{
            if(this.y < position.y){
                if(temp[2]) System.out.println("\nПуть прегражден\n");
                else this.y += 1;
            }
            else {
                if(temp[3]) System.out.println("\nПуть прегражден\n");
                else this.y -= 1;
            }
        }
    }

    public boolean[] checkPos(ArrayList<BaseHero> friends){
        boolean[] temp = new boolean[4];
        for (BaseHero u : friends){
            if((u.position.x == this.x+1) & (u.position.y == this.y)) temp[0] = true;
            if((u.position.x == this.x-1) & (u.position.y == this.y)) temp[1] = true;
            if((u.position.x == this.x) & (u.position.y == this.y+1)) temp[2] = true;
            if((u.position.x == this.x) & (u.position.y == this.y-1)) temp[3] = true;
        }
        return temp;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    
}
