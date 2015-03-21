package com.jachu.phisics;

import java.util.Random;


public class UpdateCircular implements IUpdater {
	
	private static final double ANGLE_DIF = 0.1;
	
	private double mDimX;
	private double mDimY;
	private double angle;
	private double mSpeed;

	public UpdateCircular(double d, double e){
		mDimX = d;
		mDimY = e;
		angle = 0;
		mSpeed = new Random().nextDouble();
	}
	
	@Override
	public void update() {
		updateAngle();
	}
	
	private void updateAngle() {
		angle = (angle + mSpeed*ANGLE_DIF) % (2*Math.PI);	
	}

	@Override
	public int updateX(int posX) {
		return (int) ((mDimX/2)+(100*Math.cos(angle)));
	}

	@Override
	public int updateY(int posX) {
		return (int) ((mDimY/2)+(50*Math.sin(angle)));
	}

	@Override
	public int updateLife(int life) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateColor(int color) {
		// TODO Auto-generated method stub
		return 0;
	}
}
