package com.jachu.particles;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParticlePanel extends JPanel{
	
	private int SIZE = 500;
	private static final long serialVersionUID = 1L;
	private List<ParticleStandard> mParticleList;
	
	public ParticlePanel(){
		mParticleList = new ArrayList<ParticleStandard>();
		setBackground(Color.BLACK);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(SIZE,SIZE);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		rederParticleList(g);
	}
	
	private void rederParticleList(Graphics g) {
		Iterator<ParticleStandard> it = mParticleList.iterator();
		while(it.hasNext()){
			ParticleStandard particle = it.next();
			particle.paintParticle(g);
		}
	}
	
	public void addParticleList(List<ParticleStandard> particleList){
		mParticleList = particleList;
	}
}
