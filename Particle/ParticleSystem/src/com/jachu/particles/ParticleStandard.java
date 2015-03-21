package com.jachu.particles;

import com.jachu.phisics.IUpdater;

import java.awt.*;

public class ParticleStandard {

	private static int WIDTH = 5;
	private static int LENGTH = 5;
	
	private int mOriginX;
	private int mOriginY;
	private int mInitLife;
	private int mPosX;
	private int mPosY;
	private boolean mFloating;
	private Color mColor;
	private int mLife;
	private IUpdater mUpdater;
	
	public ParticleStandard(int posX, int posY, Color color, IUpdater updater){
		mOriginX = posX;
		mOriginY = posY;
		mPosX = posX;
		mPosY = posY;
		mFloating = true;
		mColor = color;
		mUpdater = updater;
	}
	
	public int getPosX() {
		return mPosX;
	}

	public void setPosX(int posX) {
		this.mPosX = posX;
	}

	public int getPosY() {
		return mPosY;
	}

	public void setPosY(int posY) {
		this.mPosY = posY;
	}

	public Color getColor() {
		return mColor;
	}

	public void setColor(Color color) {
		this.mColor = color;
	}

	public boolean isFloating() {
		return mFloating;
	}

	public void setFloating(boolean floating) {
		this.mFloating = floating;
	}
	
	public int getLife() {
		return mLife;
	}

	public void setLife(int mLife) {
		mInitLife = mLife;
		this.mLife = mLife;
	}

	public void update(){
		mPosX = mUpdater.updateX(mPosX);
		mPosY = mUpdater.updateY(mPosY);
		mLife = mUpdater.updateLife(mLife);
		if(mLife == 0){
			initParticle();
		}
		
		mUpdater.update();
	}
	
	private void initParticle() {
		
	}

	public void paintParticle(Graphics g){
       if(mLife != 0){
		g.setColor(mColor);
        g.drawOval(mPosX, mPosY, WIDTH, LENGTH);
        g.setColor(mColor);
        g.fillOval(mPosX, mPosY, WIDTH, LENGTH);
       }
	}
}
