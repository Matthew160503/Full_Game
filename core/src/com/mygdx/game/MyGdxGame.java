package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

import com.mygdx.game.hmm.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.hmm.Units.BaseHero;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, crossbowman, mage, monk, peasant, robber, sniper, spearman;
	Music music;
	
	public static final int GANG_SIZE = 10;
    public static ArrayList<BaseHero> whiteSide;
    public static ArrayList<BaseHero> darkSide;
    public static ArrayList<BaseHero> fullStack;
	private static int step = 0;
	private static float dx, dy; 

	@Override
	public void create () {
		batch = new SpriteBatch();
		fon = new Texture("fons/"+String.valueOf(new Random().nextInt(1,7))+".png");
		music = Gdx.audio.newMusic(
				Gdx.files.internal(
					"music/m"+String.valueOf(new Random().nextInt(1,4))+".mp3"));

		music.setVolume(0.125f);
		music.setLooping(true);
		music.play();
		Init.createTeams();
		ConsoleView.view();

		int my = 0;
		crossbowman = new Texture("units/crossbowman.png");
		my = crossbowman.getHeight();
		mage = new Texture("units/mage.png");
		if(my < mage.getHeight()) my = mage.getHeight();
		monk = new Texture("units/monk.png");
		if(my < monk.getHeight()) my = monk.getHeight();
		peasant = new Texture("units/peasant.png");
		if(my < peasant.getHeight()) my = peasant.getHeight();
		robber = new Texture("units/robber.png");
		if(my < robber.getHeight()) my = robber.getHeight();
		sniper = new Texture("units/sniper.png");
		if(my < sniper.getHeight()) my = sniper.getHeight();
		spearman = new Texture("units/spearman.png");
		if(my < spearman.getHeight()) my = spearman.getHeight();
		dy = Gdx.graphics.getHeight() / 12;
		dx =  Gdx.graphics.getWidth() / 11;
	}

	@Override
	public void render () {
		if (step == 0) Gdx.graphics.setTitle("Начало"); 
		else Gdx.graphics.setTitle("Ход №"+step);
		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		for(BaseHero n : darkSide){
			switch (n.getType()){
				case "Sniper":  if(n.isAlive()) batch.draw(sniper, n.getPosition().getX()*dx, n.getPosition().getY()*dy); break;
				case "Magician": if(n.isAlive()) batch.draw(mage, n.getPosition().getX()*dx, n.getPosition().getY()*dy); break;
				case "Robber": if(n.isAlive()) batch.draw(robber, n.getPosition().getX()*dx, n.getPosition().getY()*dy); break;
				case "Peasant": if(n.isAlive()) batch.draw(peasant, n.getPosition().getX()*dx, n.getPosition().getY()*dy); break;
			}
		}
		for(BaseHero n : whiteSide){
			switch (n.getType()){
				case "Crossbowman": if(n.isAlive()) batch.draw(crossbowman, n.getPosition().getX()*dx, n.getPosition().getY()*dy); break;
				case "Monk": if(n.isAlive()) batch.draw(monk, n.getPosition().getX()*dx, n.getPosition().getY()*dy); break;
				case "Spearman": if(n.isAlive()) batch.draw(spearman, n.getPosition().getX()*dx, n.getPosition().getY()*dy); break;
				case "Peasant": if(n.isAlive()) batch.draw(peasant, n.getPosition().getX()*dx, n.getPosition().getY()*dy); break;
			}
		}

		batch.end();

		//while (true) {
		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
			step++;
			Init.makeStep();
        	//sc.nextLine();
		}
        // Init.makeStep();
        // ConsoleView.view();
        // sc.nextLine();
        //}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
	}
}
