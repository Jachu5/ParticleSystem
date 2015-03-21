package com.jachu.particles;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Emitter {

	private ArrayList<ParticleStandard> mParticleList;
	private int mNumberOfParticles;
	private IParticleInitializer mInitializer;
	
	public Emitter(Dimension dimension, int numberOfParticles) {
		mInitializer = new ParticleInitializerStandard(dimension);
		mNumberOfParticles = numberOfParticles;
	}
	
	public ArrayList<ParticleStandard> createParticlePool() {
		mParticleList = new ArrayList<ParticleStandard>();
		for (int i = 0; i< mNumberOfParticles; i++){
			mParticleList.add(mInitializer.createParticle());			
		}
		return mParticleList;
	}

	public void update(){
		Iterator<ParticleStandard> it = mParticleList.iterator();
		while(it.hasNext()){
			ParticleStandard particle = it.next();
			particle.update();
		}
	}
	
}