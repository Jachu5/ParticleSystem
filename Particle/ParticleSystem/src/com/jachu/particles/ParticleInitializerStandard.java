package com.jachu.particles;

import com.jachu.phisics.IUpdater;
import com.jachu.phisics.UpdateArchSpiral;

import java.awt.*;
import java.util.Random;

public class ParticleInitializerStandard implements IParticleInitializer{

	private final static int LIFE_AV = 300;
	private Random randomGenerator;
	private Dimension mCanvasDimension;
	
	public ParticleInitializerStandard(Dimension dimension){
		randomGenerator= new Random();
		mCanvasDimension = dimension;
	}
	
	@Override
	public ParticleStandard createParticle() {
		return generateRandomParticle();
	}
	
	private ParticleStandard generateRandomParticle() {
		int posX = (int) (mCanvasDimension.getWidth()/2);
		int posY = (int) (mCanvasDimension.getHeight()/2);
		Color color = getRandomColor();
		IUpdater updater = new UpdateArchSpiral(mCanvasDimension.getWidth(),mCanvasDimension.getHeight());
		ParticleStandard particle = new ParticleStandard(posX,posY,color,updater);
		int life = LIFE_AV + getIntRandomValue(200);
		particle.setLife(life);
		
		return particle;
	}

	private Color getRandomColor() {
		final float hue = randomGenerator.nextFloat();
		final float saturation = 0.9f;//1.0 for brilliant, 0.0 for dull
		final float luminance = 1.0f; //1.0 for brighter, 0.0 for black
		Color color = Color.getHSBColor(hue, saturation, luminance);
		
		return color;
	}

	private int getIntRandomValue(int range) {
		return randomGenerator.nextInt(range);
	}
}
