package com.jachu.phisics;

import java.util.Random;


public class UpdateArchSpiral implements IUpdater {

	private static final double A = 1;
	private static final double B = 1;
	private static final double TIME_DIF = 0.1;
	
	private double mDimX;
	private double mDimY;
	private double angle;
	private double mTime;
	private double mSpeed;
	
	
	public UpdateArchSpiral(double d, double e){
		mDimX = d/2;
		mDimY = e/2;
		angle = 0;
		mSpeed = new Random().nextDouble();
	}
	
	@Override
	public void update() {
		updateAngle();	
	}
	
	private void updateAngle() {
		mTime+= TIME_DIF;
		
	}

	@Override
	public int updateX(int posX) {
		return (int) (mDimX+(mSpeed*mTime*Math.cos(mSpeed*mTime)));
	}

	@Override
	public int updateY(int posX) {
		return (int) (mDimY+(mSpeed*mTime*Math.sin(mSpeed*mTime)));
		
	}

	@Override
	public int updateLife(int life) {
		return life-1;
	}

	@Override
	public int updateColor(int color) {
		// TODO Auto-generated method stub
		return 0;
	}	
}
