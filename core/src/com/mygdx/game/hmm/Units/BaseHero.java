package com.mygdx.game.hmm.Units;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.BoldAction;

public abstract class BaseHero implements Interface{

    protected int attack, maxHealth, defence;
    public String name;
    protected float health;
    protected int[] damage;
    protected int speed;
    protected Position position;
    public char type;
    protected int delivery;

    public BaseHero(String name, int attack, int defence, int[] damage, int maxHealth, int speed, int x, int y){ 
        this.attack = attack;
        this.maxHealth = maxHealth;
        this.defence = defence;
        this.name = name;
        this.health = maxHealth;
        this.damage = damage;
        this.speed = speed;
        this.position = new Position(x, y);
        this.type = this.name.charAt(1);
        this.delivery = 0;
    }

    public String getName(){
        return "";//this.name.charAt(0);
    }

    public float getHealth(){
        return health;
    }

    public int getSpeed(){
        return speed;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String getInfo() {
        String outStr = String.format("\t%-3s\t %-3d\t\uD83D\uDEE1 %-3d\t%-3d%%\t%-3d\t ", name, attack,defence,(int) health * 100/maxHealth,(damage[0] + damage[1])/2);
        return outStr;
    }

    @Override
    public String toString() {
        return "none";
    }

    @Override
    public void step(ArrayList<BaseHero> team,ArrayList<BaseHero> ourTeam) {
    }

    public int getDelivery(){return delivery;}
    public void checkDelivery(){}

    public void attack(BaseHero target, int[] damage){
        int causeDamage = (damage[0] + damage[1])/2;
        System.out.printf("%s атакует %s, у которого %f жизней\t\nУрон равен: %d\n", this.getName(), target.getName(), target.health,causeDamage);
        target.getDamage(target, causeDamage);
    }

    public void getDamage(BaseHero target, int damage){
        if(target.health - damage > 0){
            target.health -= damage;
           System.out.printf("Оставшиеся жизни %s равны %f\n", target.getName(), target.health);
        }
        else{
            target.health = 0;
            System.out.printf("%s убит\n", target.getName()); 
        }
    }

    public String getType(){
        return "";
    }

    public boolean isAlive(){
        return false;
    }
}
