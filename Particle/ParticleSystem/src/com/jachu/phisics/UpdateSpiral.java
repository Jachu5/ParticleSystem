package com.jachu.phisics;

import java.util.Random;


public class UpdateSpiral implements IUpdater {

	private static final double A = 1;
	private static final double B = 1;
	private static final double ANGLE_DIF = 0.01;
	
	private double mDimX;
	private double mDimY;
	private double angle;
	private double mRadius;
	private double mSpeed;
	
	
	public UpdateSpiral(double d, double e){
		mDimX = d;
		mDimY = e;
		angle = 0;
		mRadius = A*Math.exp(B*angle);
		mSpeed = new Random().nextDouble();
	}
	
	@Override
	public void update() {
		updateAngle();	
	}
	
	private void updateAngle() {
		angle = (angle + mSpeed*ANGLE_DIF) % (1000*Math.PI);
		mRadius = A*Math.exp(B*angle);
	}

	@Override
	public int updateX(int posX) {
		return (int) (mDimX/2 + (mRadius*Math.cos(angle)));
	}

	@Override
	public int updateY(int posX) {
		return (int) (mDimY/2 + (mRadius*Math.sin(angle)));
		
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
